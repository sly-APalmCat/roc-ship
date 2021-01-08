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

    /**
     *
     */
    GENERATOR_FAIL(1000,"生成失败！- | - ！");

    /**
     *
     */
    private long code;
    /**
     *
     */
    private String msg;

    /**
     *
     */
    private AliGeneratorStateCode(){}

    /**
     * @param code
     * @param say
     */
    private AliGeneratorStateCode(long code,String say){
        this.code = code;
        this.msg = say;
    }


    /**
     * @return
     */
    public long getCode() {
        return code;
    }

    /**
     * @return
     */
    public String getSay() {
        return msg;
    }
}
