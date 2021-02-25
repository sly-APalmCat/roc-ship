package com.rocship.aligenerator.localTest.customclassLoader;/**
 * Description: <br/>
 * date: 2021/2/24 10:11<br/>
 *
 * @version
 */

/**
 * ClassName: HotWapClassLoader <br/>
 * Description: <br/>
 * date: 2021/2/24 10:11<br/>
 * @author 15438<br />
 */
public class HotWapClassLoader extends ClassLoader {

    public HotWapClassLoader(){
        super(HotWapClassLoader.class.getClassLoader());
    }

    /**
     * 为了多次载入执行类而加入加载器
     * 将defineClass 开放出来，供外部调用的loadByte。
     * 由虚拟机调用时，还是尊崇双亲委派机制的loadClass方法进行类加载
     * @param classbyte
     * @return
     */
    public Class  loadByte(byte[] classbyte){
        return defineClass(null,classbyte,0,classbyte.length);
    }


}
