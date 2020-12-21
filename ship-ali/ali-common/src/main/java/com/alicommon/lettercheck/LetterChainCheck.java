package com.alicommon.lettercheck;/**
 * Description: <br/>
 * date: 2020/12/21 13:51<br/>
 *
 * @version
 */

/**
 * ClassName: LetterChainCheck <br/>
 * Description: <br/>
 * date: 2020/12/21 13:51<br/>
 * @author 15438<br />
 */
public class LetterChainCheck {


    public static boolean isLetterOfCheckPath(String letterChain){
        byte[] bytes = letterChain.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if(!Character.isLetterOrDigit(bytes[i]) && 47 != bytes[i] && 42 != bytes[i]){
                return false;
            }
        }
        return true;
    }



}
