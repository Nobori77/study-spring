package com.app.oauth.controller;

import com.app.oauth.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.model.GetObjectAclResponse;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileDisplayController {

    private final FileService fileService;

    //    ↓ 쿼리스트링
    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> display(String fileName) {
        ResponseBytes<GetObjectResponse> image = fileService.getDisplayPath(fileName);
        String imageType = image.response().contentType();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(imageType))
                .body(image.asByteArray());
    }
}
