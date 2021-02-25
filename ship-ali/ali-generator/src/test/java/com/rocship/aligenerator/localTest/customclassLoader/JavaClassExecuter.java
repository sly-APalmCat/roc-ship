package com.rocship.aligenerator.localTest.customclassLoader;/**
 * Description: <br/>
 * date: 2021/2/24 11:12<br/>
 *
 * @version
 */

import java.lang.reflect.Method;

/**
 * javaClass执行工具
 *
 * ClassName: JavaClassExecuter <br/>
 * Description: <br/>
 * date: 2021/2/24 11:12<br/>
 * @author 15438<br />
 */
public class JavaClassExecuter {


    public static String execute(byte[] classByte){
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System","com/rocship/aligenerator/localTest/customclassLoader/HackSystem");
        HotWapClassLoader loader = new HotWapClassLoader();
        Class clazz = loader.loadByte(modiBytes);

        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }

        return HackSystem.getBufferString();
    }
}
