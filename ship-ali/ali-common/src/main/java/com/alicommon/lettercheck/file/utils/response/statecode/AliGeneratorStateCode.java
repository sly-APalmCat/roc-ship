package com.alicommon.lettercheck.file.utils.response.statecode;/**
 * Description: <br/>
 * date: 2021/1/5 17:30<br/>
 *
 * @version
 */

/**
 * ClassName: AliGeneratorStateCode <br/>
 * Description: <br/>
 * date: 2021/1/5 17:30<br/>
 * @author 15438<br />
 */
public enum  AliGeneratorStateCode implements AbstractStateCode{

    GENERATOR_FAIL(1000,"生成失败！- | - ！");

    private long code;
    private String say;
    private AliGeneratorStateCode(){}
    private AliGeneratorStateCode(long code,String say){
        this.code = code;
        this.say = say;
    }


    public long getCode() {
        return code;
    }

    public String getSay() {
        return say;
    }
}
