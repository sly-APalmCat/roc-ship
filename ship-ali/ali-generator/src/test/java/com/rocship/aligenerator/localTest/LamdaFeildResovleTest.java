package com.rocship.aligenerator.localTest;/**
 * Description: <br/>
 * date: 2021/2/22 17:06<br/>
 *
 * @version
 */

import com.alibaba.fastjson.JSON;
import com.rocship.aligenerator.localTest.reself.SerializeUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.*;
//import java.lang.invoke.SerializedLambda;
import com.rocship.aligenerator.localTest.reself.SerializedLambda;
//import com.rocship.aligenerator.localTest.SerializedLambda;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.function.Function;

/**
 * ClassName: LamdaFeildResovleTest <br/>
 * Description: <br/>
 * date: 2021/2/22 17:06<br/>
 * @author 15438<br />
 */
@SuppressWarnings("unused")
public class LamdaFeildResovleTest<L>{

    static Map<Class<?>,WeakReference<SerializedLambda>> map = Collections.synchronizedMap(new HashMap<Class<?>,WeakReference<SerializedLambda>>());



    @FunctionalInterface
    interface SFunctionS<T,R>{
        String applay();
    }
    @Data
    class AOPA{
        private int age;
        private String name;

    }

    @Test
    public void ont(){
        LamdaFeildResovleTest<AFunctionA<AOPA,?>> lamdaFeildResovleTest = new LamdaFeildResovleTest<AFunctionA<AOPA,?>>();
        lamdaFeildResovleTest.sayBye(AOPA::getName);

    }




    /**
     * 获取返回参数
     */
    public <T> void sayBye(L a){
         if(a instanceof AFunctionA){
             AFunctionA s = (AFunctionA) a;
             SerializedLambda serializedLambda = resolveInCache(s);
             System.out.println(JSON.toJSONString(serializedLambda));
            // String implMethodName = serializedLambda.getImplMethodName();
            // String functionalInterfaceClass = serializedLambda.getFunctionalInterfaceClassName();
            // String functionalInterfaceMethodName = serializedLambda.getImplMethodName();
             //String implMethodSignature = serializedLambda.getImplClassName();
           //  Class<?> implClass = serializedLambda.getImplClass();
            // System.out.println(implClass);
         }

    }


    /**
     * 获取缓存解析lambda函数对象
     *
     */
    public static <T>SerializedLambda resolveInCache(AFunctionA<T,?> aFunctionA){
        Class<? extends AFunctionA> aClass = aFunctionA.getClass();

        return Optional.ofNullable(map.get(aClass)).map(WeakReference::get).orElseGet(()->{
            SerializedLambda resolve = SerializedLambda.resolve(aFunctionA);
            map.put(aClass,new WeakReference(resolve));
            return resolve;
        });

    }


    /**
     * 解析lambda表达式
     */
    public static SerializedLambda resolve(AFunctionA<?,?> aFunctionA){
        if(!aFunctionA.getClass().isSynthetic()){
            throw new IllegalArgumentException("不是合成的lambda！");
        }

        try (ObjectInputStream obji = new ObjectInputStream(new ByteArrayInputStream(SerializeUtils.serialize(aFunctionA))){
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                Class<?> aClass = super.resolveClass(desc);
                //return aClass == SerializedLambda.class ? SerializedLambda.class : aClass;
                return aClass == java.lang.invoke.SerializedLambda.class ? SerializedLambda.class : aClass;
            }
        }
        ){
            return (SerializedLambda) obji.readObject();
        }catch (Exception e){
            throw new RuntimeException("SerializedLambda happen exception", e);
        }



    }

    public static SerializedLambda resolve(SFunctionS<?,?> sFunctionS){
        System.out.println(sFunctionS.getClass().isSynthetic());

        return null;
    }





}
