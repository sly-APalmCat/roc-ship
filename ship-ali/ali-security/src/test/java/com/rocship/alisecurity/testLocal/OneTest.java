package com.rocship.alisecurity.testLocal;/**
 * Description: <br/>
 * date: 2020/12/21 13:44<br/>
 *
 * @version
 */

import com.alicommon.lettercheck.LetterChainCheck;
import com.rocship.alisecurity.config.shiro.ShiroConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.nio.ByteBuffer;

/**
 * ClassName: OneTest <br/>
 * Description: <br/>
 * date: 2020/12/21 13:44<br/>
 * @author 15438<br />
 */
public class OneTest {


    /**
     * 此测试结论就是
     * b1 | b2 << 8
     * 这个公式程序计算优先级高低 位移  --> 或/与  -->
     *
     */
    @Test
    public void llllll(){
         int i = 0;
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("asdfkl;k23423".getBytes());
        byte b = allocate.get(i++);
        byte b1 = allocate.get(i++);
        byte b2 = allocate.get(i++);
        int i1 = (b1 & 0xff) | (b2 & 0xff) << 8;
        System.out.println(Integer.toBinaryString(b1 & 0xff)); //115
        System.out.println(Integer.toBinaryString(b2 & 0xff)); //100
        System.out.println(Integer.toBinaryString(b1 | b2));  //119
        System.out.println(Integer.parseInt("111011100000000",2));
        System.out.println(119 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2);
        System.out.println(Integer.toBinaryString(b1 | b2 << 8));
        System.out.println(Integer.toBinaryString(b2 << 8));
        System.out.println(Integer.parseInt("110010000000000",2));
        System.out.println(i1);  //25715
        System.out.println(b); //97

    }

    @Test
    public void llkjjk(){
        String la = "\uD83E\uDD23\uD83D\uDE02\uD83D\uDE01\uD83D\uDE4C";
        System.out.println(la);
        char[] chars = la.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println((int)chars[i]);

        }
    }



    @Test
    public void getObjClass(){
        Class<ShiroConfig> shiroConfigClass = ShiroConfig.class;
        System.out.println(shiroConfigClass.toString());


    }

    @Test
    public void ll(){
        char p = '/';
        System.out.println((byte)p);
        p = 'a';
        System.out.println((byte)p);
        p = 'z';
        System.out.println((byte)p);
        p = 'A';
        System.out.println((byte)p);
        p = 'Z';
        System.out.println((byte)p);
        String ps = "/ff/adf/DS/";
        boolean letterOfCheckPath = LetterChainCheck.isLetterOfCheckPath(ps);
        System.out.println(letterOfCheckPath);
        p = '*';
        System.out.println((byte) p);

    }

}
