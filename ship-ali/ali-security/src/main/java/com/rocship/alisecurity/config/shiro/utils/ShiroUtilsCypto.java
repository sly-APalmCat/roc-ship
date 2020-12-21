package com.rocship.alisecurity.config.shiro.utils;/**
 * Description: <br/>
 * date: 2020/12/21 16:26<br/>
 *
 * @version
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ObjectUtils;

import java.util.Objects;
import java.util.Random;

/**
 * ClassName: ShiroUtilsCypto <br/>
 * Description: <br/>
 * date: 2020/12/21 16:26<br/>
 * @author 15438<br />
 */
public class ShiroUtilsCypto {

    static private String SHA_256 = "SHA-256";
    static private int lifecycleCryptoDigit = 16;

    public static String sha256Crypto(String passwd,String alt){
        return new SimpleHash(SHA_256,passwd,alt,new Random().nextInt(17)).toString();
    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Object getSessionObject(String key){
        return getSession().getAttribute(key);
    }

    public static String getKaptchaVal(String key){
        Object sessionObject = getSession().removeAttribute(key);
        if(ObjectUtils.isEmpty(sessionObject)){
            throw new RuntimeException("验证码已失效！");
        }
        return String.valueOf(sessionObject);
    }

    public static boolean isLogin(){
        return Objects.nonNull(getSubject().getPrincipal());
    }

    public static void isLoginOut(){
        getSubject().logout();
    }






}
