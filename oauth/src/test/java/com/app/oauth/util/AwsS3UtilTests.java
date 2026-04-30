package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AwsS3UtilTests {
    @Autowired
    private AwsS3Util awsS3Util;

    @Test
    public void getPathTest(){
        log.info(awsS3Util.getPath());
    }

    @Test
    public void displayTest(){
        log.info("{}", awsS3Util.display("/2026/04/30/3800ef4e-52d6-4813-be3a-fe69466f37ef_images.jpg"));
    }

}
