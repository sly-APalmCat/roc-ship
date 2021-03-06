package com.rocship.aligenerator;

import com.rocship.aligenerator.localTest.autoInjoin.PermissonCheckHodler;
import org.apache.commons.lang.SystemUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.*;

@SpringBootTest
class AligeneratorApplicationTests {

    //todo 可以做到自动注入
@Autowired
Map<String,PermissonCheckHodler> map = new HashMap<String,PermissonCheckHodler>();

    @Test
    public void two(){
        String one = "onePermissonCheckHodler";
        String two = "twoPermissonCheckHodler";
        PermissonCheckHodler permissonCheckHodler = map.get(one);
        PermissonCheckHodler permissonCheckHodler1 = map.get(two);
        permissonCheckHodler.say();
        permissonCheckHodler1.say();

    }



    ///todo 测试spi机制
    ///todo META-INF/services  ，下要完成的spi机制的全类名
    ///todo 此测试支持独立类对象，以及内部类对象
    @Test
    public void one(){

        ServiceLoader<com.rocship.aligenerator.localTest.Po> load = ServiceLoader.load(com.rocship.aligenerator.localTest.Po.class);
        for (com.rocship.aligenerator.localTest.Po po : load) {
            po.say();
        }

//        Iterator<Po> iterator = load.iterator();
//        iterator.forEachRemaining(ii ->ii.say());
    }


    @Test
    void contextLoads() throws IOException {
        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
        ClassPathResource pathResource = new ClassPathResource("template");
        String path = pathResource.getPath();
        System.out.println(path);
        File userDir = SystemUtils.getUserDir();
        System.out.println(userDir.getAbsolutePath());
    }

}
