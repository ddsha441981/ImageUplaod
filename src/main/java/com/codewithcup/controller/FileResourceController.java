package com.codewithcup.controller;

import com.codewithcup.payload.FileResponse;
import com.codewithcup.service.FileResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
}
