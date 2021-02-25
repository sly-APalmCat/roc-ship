package com.rocship.aligenerator.localTest.customclassLoader;/**
 * Description: <br/>
 * date: 2021/2/24 10:27<br/>
 *
 * @version
 */

/**
 * 修改class文件，暂时只提供修改常量池常量功能
 *
 * ClassName: ClassModifier <br/>
 * Description: <br/>
 * date: 2021/2/24 10:27<br/>
 * @author 15438<br />
 */
public class ClassModifier {

    /**
     * class文件中常量池的起始偏移
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;
    /**
     * CONSTANT_utf8_info 常量的tag标志
     */
    private static final int CONSTANT_utf8_info = 1;
    /**
     * 常量池中11种常量所占的长度，CONSTANT_utf8_info型常量除外，因为他不是定长的。TODO 查一下常量的11种常量所占的长度
     */
    private static final int[] CONSTANT_ITEM_LENGTH = {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};

    private static final int u1 = 1;
    private static final int u2 =2;

    private byte[] classByte;
    public ClassModifier(byte[] classByte){
        this.classByte = classByte;
    }

    /**
     * 修改常量池种CONSTANT_utf8_info常量的内容
     */
    public byte[] modifyUTF8Constant(String oldstr,String newstr){
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX +u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.bytes2Int(classByte,offset,u1);
            if(tag == CONSTANT_utf8_info){
                int len = ByteUtils.bytes2Int(classByte,offset+u1,u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(classByte,offset,len);
                if(str.equalsIgnoreCase(oldstr)){
                    byte[] strBytes = ByteUtils.string2Bytes(newstr);
                    byte[] strLen = ByteUtils.int2Bytes(newstr.length(),u2);
                    classByte = ByteUtils.bytesReplace(classByte,offset - u2,u2,strLen);
                    classByte = ByteUtils.bytesReplace(classByte,offset,len,strBytes);
                    return classByte;
                }else {
                    offset += len;
                }
            }else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }

    /**
     * 获取常量池种常量的数量
     * @return 常吃数量
     */
    public int getConstantPoolCount() {
        return ByteUtils.bytes2Int(classByte,CONSTANT_POOL_COUNT_INDEX,u2);
    }


}
