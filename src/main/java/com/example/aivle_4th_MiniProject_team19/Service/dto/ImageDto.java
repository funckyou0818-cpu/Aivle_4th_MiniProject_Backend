package com.example.aivle_4th_MiniProject_team19.Service.dto;

import com.example.aivle_4th_MiniProject_team19.Entity.Image;
import com.example.aivle_4th_MiniProject_team19.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private String originFileName;
    private String modifiedFileName;

    // Entity -> Dto
    public static ImageDto from(Image image) {

        if (image == null) {
            return null;
        }

        return ImageDto.builder()
                .originFileName(image.getOriginFileName())
                .modifiedFileName(image.getModifiedFileName())
                .build();
    }
}
