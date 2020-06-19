package com.jasonvanblarcum.showcase.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uploadingfiles.storage.StorageService;

import javax.annotation.Resource;

@Controller
public class UploadController {

    //TODO 1. Make it so artwork can be a) loaded from UploadController b) through ArtworkRepository and c) using the Artwork model
    //TODO 2. Artwork should be viewed on user profile and gallery once loaded
    //TODO 3. Remove references to Post once template is removed

    @Autowired
    private ArtworkRepository artworkRepository;

    private final StorageService storageService;

    public UploadController(StorageService storageService) {
        this.storageService = storageService;
    }
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(UploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));
            return "uploadForm";
        }

        @GetMapping("/files/{filename:.+}")
        @ResponseBody
        public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
            Resource file = (Resource) storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        }
        @PostMapping("/")
        public String handleFileupload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully upload " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
