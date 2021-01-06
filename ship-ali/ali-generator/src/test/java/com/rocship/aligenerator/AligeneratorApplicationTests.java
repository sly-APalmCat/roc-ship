package com.rocship.aligenerator;

import org.apache.commons.lang.SystemUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@SpringBootTest
class AligeneratorApplicationTests {

    @Test
    void contextLoads() throws IOException {
        ClassPathResource pathResource = new ClassPathResource("template");
        String path = pathResource.getPath();
        System.out.println(path);
        File userDir = SystemUtils.getUserDir();
        System.out.println(userDir.getAbsolutePath());
    }

}
