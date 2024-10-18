package com.istore.istoreproject.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

@Service
public class UploadService {

    public String saveFile(MultipartFile file) throws IOException {
        // Generate a random file name to avoid clashes
        @SuppressWarnings("null")
        String fileName = generateRandomString() + "_" + StringUtils.cleanPath(file.getOriginalFilename());

        // Specify the folder path where you want to save the file
        String folderPath = "C:/Users/Aymen Omri/Desktop/Fiverr/isotre/istore-project/src/main/resources/uploads/";

        // Create a Path object for the folder
        Path folder = Paths.get(folderPath);

        // Ensure that the folder exists; if not, create it
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }

        // Specify the destination path where the file will be saved
        Path destinationPath = folder.resolve(fileName);

        // Copy the file to the destination path
        Files.copy(file.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        // Return the absolute path of the saved file
        return destinationPath.toString();
    }

    private String generateRandomString() {
        return UUID.randomUUID().toString().substring(0, 20);
    }

}
