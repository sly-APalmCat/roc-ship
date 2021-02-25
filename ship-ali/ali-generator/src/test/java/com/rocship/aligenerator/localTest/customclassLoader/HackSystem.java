package com.rocship.aligenerator.localTest.customclassLoader;/**
 * Description: <br/>
 * date: 2021/2/24 11:01<br/>
 *
 * @version
 */

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 为javaclass劫持Java.lang.System 提供支持
 * 除了out 和 err外，其余的都直接转发给system处理
 *
 * ClassName: HackSystem <br/>
 * Description: <br/>
 * date: 2021/2/24 11:01<br/>
 * @author 15438<br />
 */
public class HackSystem {

    public final static InputStream in = System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public final static PrintStream out = new PrintStream(buffer);
    public final static PrintStream err = out;

    public static String getBufferString(){
        return buffer.toString();
    }

    public static void clearBuffer(){
        buffer.reset();
    }

    public static  void setSecurityManager(final SecurityManager s){
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager(){
        return System.getSecurityManager();
    }

    public static long currentTimeMillis(){
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length){
        System.arraycopy(src,srcPos,dest,destPos,length);
    }

    public static int identityHshCode(Object x){
        return System.identityHashCode(x);
    }

    /**
     * 下面所有的方法都与java.lang.System的名称一样
     * 实现都是字节转调Ssytem的对应方法
     * 参考出省略其他方法；
     */



}
