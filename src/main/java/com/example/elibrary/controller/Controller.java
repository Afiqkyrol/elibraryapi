package com.example.elibrary.controller;

import com.example.elibrary.entity.DtMonographRegistration;
import com.example.elibrary.repository.DtMonographRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class Controller {


    @Autowired
    private DtMonographRegistrationRepository dtMonographRegistrationRepository;

    @GetMapping("/public/image/{mono_id}")
    public ResponseEntity<Resource> getMonoImage(@PathVariable int mono_id){
        String image_name =  dtMonographRegistrationRepository.findImageById(mono_id);
        String rootPath = System.getProperty("catalina.home");
        rootPath = rootPath + "/elibrary/book cover page";
        // Resolve file path within Tomcat's file system
        Path filePath = Paths.get(rootPath).resolve(image_name);
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + image_name);
        }

        // Determine the file's MIME type
        String contentType;
        try {
            contentType = Files.probeContentType(filePath);
        } catch (IOException e) {
            contentType = "application/octet-stream";
        }

        // Set content disposition
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .headers(headers)
                .body(resource);
    }

    @GetMapping("/public/ebook/pdf/{mono_id}")
    public ResponseEntity<Resource> getEbookPdf(@PathVariable int mono_id){
        String pdf_name =  dtMonographRegistrationRepository.findEbookById(mono_id);
        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(mono_id);
        dtMonographRegistration.setReg_download_count(dtMonographRegistration.getReg_download_count()+1);
        dtMonographRegistrationRepository.save(dtMonographRegistration);

        String rootPath = System.getProperty("catalina.home");
        rootPath = rootPath + "/elibrary/ebook pdf";
        // Resolve file path within Tomcat's file system
        Path filePath = Paths.get(rootPath).resolve(pdf_name);
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + pdf_name);
        }

        // Determine the file's MIME type
        String contentType;
        try {
            contentType = Files.probeContentType(filePath);
        } catch (IOException e) {
            contentType = "application/octet-stream";
        }

        // Set content disposition
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .headers(headers)
                .body(resource);
    }
}
