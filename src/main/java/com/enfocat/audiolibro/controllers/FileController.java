package com.enfocat.audiolibro.controllers;

import org.springframework.stereotype.Controller;

import com.enfocat.audiolibro.models.Chapter;
import com.enfocat.audiolibro.models.Story;
import com.enfocat.audiolibro.payload.UploadFileResponse;
import com.enfocat.audiolibro.repositories.ChapterRepository;
import com.enfocat.audiolibro.repositories.StoryRepository;
import com.enfocat.audiolibro.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    private StoryRepository storyRepository;
    private ChapterRepository chapterRepository;
    
    @Autowired
    public FileController(StoryRepository storyRepository, ChapterRepository chapterRepository) {
        this.storyRepository = storyRepository;
        this.chapterRepository = chapterRepository;
    }

    

    @PostMapping("/uploadFile/{id}")
    public String uploadFile(@PathVariable long id ,@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        System.out.println(id);
        Story story = storyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid contacto Id:" + id));

        story.setCover(fileName);
        storyRepository.save(story);

        System.out.println(fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse up = new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        // return new UploadFileResponse(fileName, fileDownloadUri,
        //         file.getContentType(), file.getSize());

        return "redirect:/story/{id}";
    }

    @PostMapping("/uploadAudio/{id}")
    public String uploadAudio(@PathVariable long id,@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        System.out.println(id);
        Chapter chapter = chapterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid contacto Id:" + id));

        chapter.setFileaudio(fileName);
        chapterRepository.save(chapter);

        System.out.println(fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse up = new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        // return new UploadFileResponse(fileName, fileDownloadUri,
        //         file.getContentType(), file.getSize());

        return "redirect:/chapter/{id}";
    }

    // @PostMapping("/uploadMultipleFiles")
    // public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
    //     return Arrays.asList(files)
    //             .stream()
    //             .map(file -> uploadFile(file))
    //             .collect(Collectors.toList());
    // }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}