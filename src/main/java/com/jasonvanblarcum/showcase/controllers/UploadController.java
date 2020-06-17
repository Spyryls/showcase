package com.jasonvanblarcum.showcase.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/posts/upload")
public class UploadController {

    //TODO 1. Make it so artwork can be a) loaded from UploadController b) through ArtworkRepository and c) using the Artwork model
    //TODO 2. Artwork should be viewed on user profile and gallery once loaded
    //TODO 3. Remove references to Post once template is removed

    @Autowired
    private ArtworkRepository artworkRepository;

    private static String UPLOADED_FOLDER = "E://uploadedfiles//";

    @GetMapping
    public String displayUpload(Model model) {
        return "/upload/uploadedFile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
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

