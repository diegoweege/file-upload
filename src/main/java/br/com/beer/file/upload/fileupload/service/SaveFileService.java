package br.com.beer.file.upload.fileupload.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import br.com.beer.file.upload.fileupload.request.UploadFile;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SaveFileService {

    public static final Path PATH = Paths.get("src\\main\\resources\\images");
    public static final String ENDPOINT_GET_IMAGE = "http://localhost:8082/file-upload/image/";

    public String execute(final UploadFile uploadFile) throws IOException {

        generateDelay();

        log.info("Criando novo arquivo.");

        final long timeInMilli = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        final String filename = timeInMilli + ".png";

        FileUtils.writeByteArrayToFile(new File(PATH.toAbsolutePath().toString() + "\\" + filename), uploadFile.getFile());

        return ENDPOINT_GET_IMAGE + filename;
    }

    private void generateDelay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
