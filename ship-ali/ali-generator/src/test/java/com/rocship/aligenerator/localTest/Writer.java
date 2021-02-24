package com.rocship.aligenerator.localTest;/**
 * Description: <br/>
 * date: 2021/1/6 16:54<br/>
 *
 * @version
 */

import ch.qos.logback.classic.pattern.ThrowableHandlingConverter;
import com.alibaba.fastjson.JSON;
import com.alicommon.lettercheck.file.utils.response.Res;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang.WordUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.proxy.Enhancer;
import sun.misc.Unsafe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * ClassName: Writer <br/>
 * Description: <br/>
 * date: 2021/1/6 16:54<br/>
 *
 * @author 15438<br               />
 */
public class Writer<L> {

    @FunctionalInterface
    interface SFunction{
        Object get();
    }
    @Data
    class APO{
        private int p;
        private String name;
    }
    @FunctionalInterface
    interface AFunction<T,P> extends Function<T,P>,Serializable {}

    public void cc(SFunction p ){
        System.out.println(JSON.toJSONString(p.get()));
    }

    public void pp(L p){
        if(p instanceof AFunction){
            AFunction af = (AFunction) p;
            Class<? extends AFunction> aClass = af.getClass();
            Field[] fields = aClass.getFields();
            System.out.println(Arrays.asList(fields));
        }
        if(p instanceof String){
            System.out.println((String)p);
            return;
        }
        throw new RuntimeException("不是String");

    }


    @Test
    public void six() {
        AppQ a = AppQ.builder().id(1).name("青菜").money(23.0).build();
        Writer<AFunction<APO, ?>> aFunctionWriter = new Writer<AFunction<APO, ?>>();
        APO  apo = new APO();
        apo.setName("小红");
        cc(a::getId);
        aFunctionWriter.pp(APO::getName);

    }

    @Test
    public void five(){
        final ArrayList<AppQ> appQS = new ArrayList<>();
        AppQ a = AppQ.builder().id(1).name("青菜").money(23.0).build();
        AppQ b = AppQ.builder().id(1).name("青菜2").money(2.0).build();
        AppQ c = AppQ.builder().id(1).name("青菜3").money(21.0).build();
        boolean b1 = appQS.addAll(Arrays.asList(a, b, c));
        AppQ appQ1 =  AppQ.builder().build();
        AppQ appQ = appQS.stream().reduce((i, o) -> {
            BeanUtils.copyProperties(i,appQ1);
            appQ1.setMoney(i.getMoney() + o.getMoney());
            return appQ1;
        }).get();
        System.out.println(appQ.toString());
        DoubleSummaryStatistics doubleSummaryStatistics = appQS.stream().flatMapToDouble(i -> DoubleStream.of(i.getMoney())).summaryStatistics();
        System.out.println(doubleSummaryStatistics.getSum());
        DoubleStream doubleStream = appQS.stream().flatMapToDouble(i -> DoubleStream.of(i.getMoney()));


        Map<Integer, List<AppQ>> collect = appQS.stream().collect(Collectors.groupingBy(o -> o.getId(), Collectors.toList()));
        collect.forEach((k,v) -> System.out.println(k+"::"+v));


        Map<Integer, AppQ> collect1 = appQS.stream().collect(Collectors.toMap(o -> appQS.indexOf(o), p -> p));
        collect1.forEach((k,v) -> System.out.println(k+"::"+v));
    }



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
    public static Integer getPP(){
        return 34;
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
@Data
@Builder
class AppQ{
    private Integer id;
    private String name;
    private Double money;

}


 class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args)
    {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20)
            {
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }
    @Override
    public Integer call() throws Exception
    {
        int i = 0;
        for(;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        Thread.sleep(20000);
        return i;
    }
}