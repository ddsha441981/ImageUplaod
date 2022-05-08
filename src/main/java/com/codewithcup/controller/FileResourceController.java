package com.codewithcup.controller;

import com.codewithcup.payload.FileResponse;
import com.codewithcup.service.FileResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/")
public class FileResourceController {
    @Autowired
    private FileResourceService fileResourceService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/file/upload")
    public ResponseEntity<FileResponse> uploadsImage(@RequestParam("image") MultipartFile image) {
        String fileName = null;
        try {
            fileName = this.fileResourceService.uploadImage(path, image);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null,"Image is not uploaded due to server error!!!"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(fileName,"Image is successfully uploaded!!!"),HttpStatus.OK);
    }

    //Method to serve file
    @GetMapping(value = "/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,HttpServletResponse response) throws IOException {

        InputStream resource = this.fileResourceService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }
}
