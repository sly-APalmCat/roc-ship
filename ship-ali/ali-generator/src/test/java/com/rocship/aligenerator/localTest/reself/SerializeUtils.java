package com.rocship.aligenerator.localTest.reself;/**
 * Description: <br/>
 * date: 2021/2/23 9:15<br/>
 *
 * @version
 */

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * ClassName: SerializeUtils <br/>
 * Description: <br/>
 * date: 2021/2/23 9:15<br/>
 * @author 15438<br />
 */

public class SerializeUtils {
    /**
     * 序列化对象
     */
    public static byte[] serialize(Object obj){
        if(Objects.isNull(obj)){
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        }catch (Exception e){
            throw new IllegalArgumentException("serialize 对象exception!",e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
