package com.rocship.aligenerator.localTest;/**
 * Description: <br/>
 * date: 2021/1/6 16:54<br/>
 *
 * @version
 */

import ch.qos.logback.classic.pattern.ThrowableHandlingConverter;
import com.alicommon.lettercheck.file.utils.response.Res;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.apache.commons.lang.WordUtils;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import sun.misc.Unsafe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * ClassName: Writer <br/>
 * Description: <br/>
 * date: 2021/1/6 16:54<br/>
 *
 * @author 15438<br               />
 */
public class Writer<L> {





    @Test
    public void four(){

          CountDownLatch countDownLatch = new CountDownLatch(100);



    }




    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR})
    @Inherited
    public @interface  kj{}

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface  k2j {}

    @Test
    public void lokj() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object res = new Res();
        Class clazz = res.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            if("msg".equalsIgnoreCase(name)){
                Method setMethod = clazz.getDeclaredMethod("set" +WordUtils.capitalize(name),String.class); //获取注解的属性 String annoValue = anno.value(); //将注解的属性值赋给对应的属性 setMethod.invoke(obj,annoValue);
                setMethod.invoke(res,"haha");
                System.out.println(res.toString());
            }
        }

    }



    public static Integer calc(Integer para) {
        return para / 2;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ArrayList<Object> objects = new ArrayList<>();


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(String.class);
        enhancer.create();
        CompletableFuture<Void> fu =
                CompletableFuture.supplyAsync(() -> calc(50))
                .thenCompose((i) -> CompletableFuture.supplyAsync(() -> calc(i)))
                .thenApply((str) -> {return "\"" + str + "\"";}).thenAccept(System.out::println);
        System.out.println(fu.isCancelled());
        Object obj = fu.get();
      //  System.out.println(obj.toString());
        System.out.println(fu.isDone());
        final CompletableFuture<Object> objectCompletedFuture = new CompletableFuture<>();
        Thread thread = new Thread( new Runnable(){
            public void run(){
                try {
                    System.out.println("--------------------------");
                    System.out.println(objectCompletedFuture.get().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        );
        thread.start();
        Thread.sleep(5000);
    }

    @Test
    public void two() {
        Unsafe unsafe = Unsafe.getUnsafe();
        int i = unsafe.addressSize();


    }


    @Test
    public void one() throws IOException {
        StringWriter stringWriter = new StringWriter();
        StringBuffer buffer = stringWriter.getBuffer();
        buffer.append("lkjlkjlkjlkjlkjlkjk");
        buffer.insert(3, 34);

        BufferedWriter writer = new BufferedWriter(new StringWriter());
        String p = "34";
        writer.append("dfd");
        java.io.Writer append = writer.append(p);

        char[] bytes = new char[1024];
        writer.write(bytes);
        writer.flush();
        System.out.println(String.valueOf(bytes));

        append.write(bytes);
        append.close();
        System.out.println(String.valueOf(bytes));
        System.out.println(stringWriter.toString());

        stringWriter.write(bytes);
        stringWriter.close();
        System.out.println(String.valueOf(bytes));


    }


}
