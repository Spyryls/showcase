package com.jasonvanblarcum.showcase.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/forum")
public class UploadController {

    private static String UPLOADED_FOLDER = "E://uploadedfiles//";

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String fileToUpload(@RequestParam("description") String description, @RequestParam("file") MultipartFile file) {

        String status = "";
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File dir = new File(UPLOADED_FOLDER);
                    if (!dir.exists())
                        dir.mkdir();
                    File uploadedFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    outputStream.write(bytes);
                    outputStream.close();
                    status = status + "Successfully Uploaded File=" + file.getOriginalFilename();
                } catch (Exception e) {
                    status = status + "Failed to Upload " + file.getOriginalFilename() + " " + e.getMessage();
                }
                }
            return status;
    }
}

