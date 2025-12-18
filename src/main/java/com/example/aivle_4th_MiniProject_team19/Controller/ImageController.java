package com.example.aivle_4th_MiniProject_team19.Controller;

import com.example.aivle_4th_MiniProject_team19.Entity.Image;
import com.example.aivle_4th_MiniProject_team19.Service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    // 1) 새 이미지 생성
    @PostMapping
    public ResponseEntity<Image> uploadImage(@RequestBody Map<String, String> body) throws Exception {
        String originUrl = body.get("originUrl");
        Image image = imageService.saveImageFromUrl(originUrl);
        return ResponseEntity.ok(image);
    }

    // 2) 기존 이미지를 덮어쓰기 (표지 업로드)
    @PatchMapping("/{id}")
    public ResponseEntity<Image> updateImage(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) throws Exception {

        String originUrl = body.get("originUrl");
        Image updated = imageService.updateImage(id, originUrl);

        return ResponseEntity.ok(updated);
    }
}

