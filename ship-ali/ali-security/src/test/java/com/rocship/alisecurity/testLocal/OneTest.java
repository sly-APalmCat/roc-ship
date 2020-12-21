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

/**
 * ClassName: OneTest <br/>
 * Description: <br/>
 * date: 2020/12/21 13:44<br/>
 * @author 15438<br />
 */
public class OneTest {


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
