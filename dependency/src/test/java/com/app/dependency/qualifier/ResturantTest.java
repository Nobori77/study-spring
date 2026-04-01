package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ResturantTest {

    @Autowired @Qualifier("vips")
    private com.app.dependency.qualifier.Resturant resturant;

    @Test
    public void resturantTest(){
        log.info("ResturantTest");
        log.info("resturant : {}", resturant);
        log.info("resturant.isSaladBar() : {}", resturant.isSaladBar());
    }


}
