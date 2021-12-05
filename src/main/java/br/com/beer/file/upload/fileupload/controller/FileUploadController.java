package br.com.beer.file.upload.fileupload.controller;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beer.file.upload.fileupload.request.UploadFile;
import br.com.beer.file.upload.fileupload.service.FindFileService;
import br.com.beer.file.upload.fileupload.service.SaveFileService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file-upload")
@RequiredArgsConstructor
public class FileUploadController {

    private final SaveFileService saveFileService;
    private final FindFileService findFileService;

    @PostMapping("/image")
    public String uploadImage(@RequestBody UploadFile uploadFile) throws IOException {
        return saveFileService.execute(uploadFile);
    }

    @GetMapping(value = "/image/{filename}", produces = IMAGE_PNG_VALUE)
    public byte[] get(@PathVariable String filename) throws IOException {
        return findFileService.execute(filename);
    }
}
