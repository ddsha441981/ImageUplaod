package com.codewithcup.service.serviceImpl;

import com.codewithcup.service.FileResourceService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileResourceServiceImpl implements FileResourceService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
//        Getting File Name
        String name = file.getOriginalFilename();

//      Random Name Generate of file
        String randomId = UUID.randomUUID().toString();
        String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));


//        Full File Path
        String filePath = path + File.separator + fileName1;

//        Create Folder if not created
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
//        File Copy/Upload
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return name;
    }
}
