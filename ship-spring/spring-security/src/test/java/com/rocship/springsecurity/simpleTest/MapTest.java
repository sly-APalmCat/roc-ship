package com.rocship.springsecurity.simpleTest;/**
 * Description: <br/>
 * date: 2020/12/9 9:54<br/>
 *
 * @version
 */

import org.junit.jupiter.api.Test;
import sun.applet.AppletClassLoader;
import sun.net.NetworkClient;
import sun.net.NetworkServer;

import java.io.IOException;
import java.net.Socket;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
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
    public void kkkk(){

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1",23242);
        hashMap.put("str",1123242);
        if(hashMap.containsKey("str")){

        }


    }

      @Test
    public void lp() throws IOException {
        NetworkClient net = new NetworkClient("localhost",9099);

        new Thread(() ->{
            try {
                while (true){
                    Thread.sleep(100000);
                    // net.serverOutput.write("我爱你".getBytes());
                    net.serverOutput.print("哈哈哈哈哈哈！");
                    net.serverOutput.flush();
                    if(net.serverOutput == null){
                        System.out.println("是关闭");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        // net.serverOutput.flush();
        byte[] bytes = new byte[300];
        while (net.serverIsOpen()){
            System.out.println("------------------------  agin  -----------------------------");
            int read = net.serverInput.read(bytes,0,bytes.length) ;
            if(read >= 0 && read != -1){
                System.out.println(new String(bytes,"ISO8859_1"));
                System.out.println(read);
                //System.out.println(net.serverInput.available());
            }
            System.out.println("-----------------------------------------------------");
        }


    }


    @Test
    public void llp(){
           // NetworkServer.main(null);

            try {
                //Class<?> aClass = URLClassLoader.getSystemClassLoader().loadClass("sun.net.NetworkServer");
                Class<?> aClass = Class.forName("com.rocship.springsecurity.simpleTest.Ap");
                Object o = aClass.newInstance();
                if(o instanceof NetworkServer){
                    NetworkServer net = (NetworkServer) o;
                    net.startServer(9099);
                }else if(o instanceof Ap){
                    Ap ap = (Ap) o;
                    ap.startServer(9099);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (true);
    }


    public class AAAPP extends  NetworkServer{

    }

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
