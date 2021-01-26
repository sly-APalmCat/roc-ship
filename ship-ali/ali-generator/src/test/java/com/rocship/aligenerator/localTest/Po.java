package com.rocship.aligenerator.localTest;/**
 * Description: <br/>
 * date: 2021/1/20 15:25<br/>
 *
 * @version
 */

import lombok.Data;
import org.apache.commons.lang.WordUtils;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * ClassName: Po <br/>
 * Description: <br/>
 * date: 2021/1/20 15:25<br/>
 * @author 15438<br />
 */
//@Data
public interface Po<L> {
//    private String name;
//    private int age;
     void say();
    public  class Man implements Po{

        @Override
        public void say() {
            System.out.println(WordUtils.capitalize("i am man"));
        }
    }
    public    class WoMan implements Po{

        @Override
        public void say() {
            System.out.println(WordUtils.capitalize("i am woMan"));
        }
    }
}
