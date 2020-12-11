package com.rocship.springsecurity.simpleTest;/**
 * Description: <br/>
 * date: 2020/12/9 9:54<br/>
 *
 * @version
 */

import org.junit.jupiter.api.Test;
import sun.applet.AppletClassLoader;

import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: MapTest <br/>
 * Description: <br/>
 * date: 2020/12/9 9:54<br/>
 * @author 15438<br />
 */
public class MapTest {


    @Test
    public void lll(){
        int [] nums1 = new int[]{1,3,4,3,1};
        int [] nums2 = new int[]{2,31,34,23,11};
        findMedianSortedArrays(nums1,nums2);
    }


    public Double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int mark = nums1.length ;
        int[] ap = nums1 ;
        for (int i = 0; i < ints.length; ) {
           for (int j = 0; j < ints.length; j++) {
               if(j == nums2.length && i == ints.length){
                   break;
               }
               if(j == mark && i == mark){
                   j = 0;
                   ap = nums2;
               }
                   ints[i++] = ap[j];
            }
        }
        for (int i = 0; i < ints.length ; i++) {
            for (int j = 0; j < ints.length ; j++) {
                int p = ints[i];
                if(p < ints[j]){
                    ints[i] = ints[j];
                    ints[j] = p;
                }
            }
        }

        for (int i = 0; i < ints.length ; i++) {
            System.out.println(ints[i]);
        }
        int i1 = ints.length % 2;
        if(i1 == 0){
            int i = ints.length / 2;
            return (ints[i] + ints[i + 1] )/2D;
        }
        return ints[i1] / 1d;


    }

    public static Map map = new HashMap<>();
    public static HashMap map2 = new HashMap<>();

    @Test
    public void j(){
        map.put("one",123);
        map2.put("1",1);
        map.put("every",2);

        map.merge("every","zl",(s,p) ->{
            System.out.println(s);
            System.out.println(p);
            return 3;
        });
        map.forEach((t,p)->{
            System.out.println(t +" : "+p);
        });
        map2.forEach((t,p)->{
            System.out.println(t +" -- "+p);
        });
        Object two = map.getOrDefault("two", 3);
        System.out.println(two);

    }

}
