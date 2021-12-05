package br.com.beer.file.upload.fileupload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FindFileService {

    public byte[] execute(final String filename) throws IOException {
        return Files.readAllBytes(Paths.get("src\\main\\resources\\images\\" + filename));
    }
}
