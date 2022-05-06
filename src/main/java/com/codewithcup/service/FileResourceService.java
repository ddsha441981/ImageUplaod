package com.codewithcup.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileResourceService {
    public String uploadImage(String path, MultipartFile file) throws IOException;
}
