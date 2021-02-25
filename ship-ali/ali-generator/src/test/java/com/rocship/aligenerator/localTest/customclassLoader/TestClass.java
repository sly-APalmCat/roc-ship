package com.rocship.aligenerator.localTest.customclassLoader;/**
 * Description: <br/>
 * date: 2021/2/24 11:22<br/>
 *
 * @version
 */

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: TestClass <br/>
 * Description: <br/>
 * date: 2021/2/24 11:22<br/>
 * @author 15438<br />
 */
public class TestClass {

    /**
     * 自定义加载 class文件，main方法返回异常信息
     * @throws Exception
     */
    @Test
    public void one() throws Exception {
        URL url = new URL("file:///F:\\git-ship\\roc-ship\\ship-ali\\ali-generator\\target\\test-classes\\com\\rocship\\aligenerator\\localTest\\customclassLoader\\testmain");
        Path path = Paths.get(url.toURI());
        List<Path> pathStream = Files.find(path, 10, (v, b) -> {
            return v.toString().endsWith(".class");
        }).collect(Collectors.toList());
        System.out.println(pathStream.toString());
        pathStream.forEach(TestClass::readAllBytes);

    }

    public static void readAllBytes(Path path){
        try {
            byte[] bytes = Files.readAllBytes(path);
            String execute = JavaClassExecuter.execute(bytes);
            System.out.println("============= start =============");
            System.out.println(execute);
            System.out.println("============ end   ===============");
        } catch (IOException e) {
            System.out.println("报错了");
        }

    }





}
