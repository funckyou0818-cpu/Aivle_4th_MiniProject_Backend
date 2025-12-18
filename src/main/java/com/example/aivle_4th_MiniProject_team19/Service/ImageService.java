package com.example.aivle_4th_MiniProject_team19.Service;

import com.example.aivle_4th_MiniProject_team19.Entity.Image;
import com.example.aivle_4th_MiniProject_team19.Repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageService {

    private final ImageRepository imageRepository;

    private static final String BASE_DIR = "C:/image-uploads";

    public Image saveImageFromUrl(String input) throws IOException {

        String fileName = UUID.randomUUID() + ".png";

        Path uploadPath = Paths.get(BASE_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);

        // ⭐ CASE 1: Base64로 들어온 경우
        if (input.startsWith("data:image")) {
            saveBase64(input, filePath);
        }
        // ⭐ CASE 2: URL로 들어온 경우
        else {
            saveFromUrl(input, filePath);
        }

        // DB 저장
        Image image = new Image();
        image.setOriginFileName(input);
        image.setModifiedFileName(fileName);


        return imageRepository.save(image);
    }

    // URL 저장 기능 — 기존 방식 유지
    private void saveFromUrl(String originUrl, Path filePath) throws IOException {

        URL url = new URL(originUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        InputStream inputStream = connection.getInputStream();

        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    // Base64 저장 기능
    private void saveBase64(String base64, Path filePath) throws IOException {

        String base64Data = base64.substring(base64.indexOf(",") + 1);

        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

        Files.write(filePath, decodedBytes);
    }

    /**
     * 기존 이미지 덮어쓰기 (PATCH)
     */
    public Image updateImage(Long id, String input) throws IOException {

        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found: " + id));

        String fileName = image.getModifiedFileName();
        if (fileName == null) {
            fileName = UUID.randomUUID() + ".png";
        }

        Path uploadPath = Paths.get(BASE_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);

        // BASE64 처리
        if (input.startsWith("data:image")) {
            saveBase64(input, filePath);
        }
        // URL 처리
        else {
            saveFromUrl(input, filePath);
        }

        // DB 업데이트
        image.setOriginFileName(input);
        image.setModifiedFileName(fileName);


        return imageRepository.save(image);
    }
}
