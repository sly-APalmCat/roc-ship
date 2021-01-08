package com.alicommon.lettercheck.file.utils.response.statecode;/**
 * Description: <br/>
 * date: 2021/1/7 15:24<br/>
 *
 * @version
 */

/**
 * ClassName: CommonResponseCode <br/>
 * Description: <br/>
 * date: 2021/1/7 15:24<br/>
 * @author 15438<br />
 */
@SuppressWarnings("all")
public enum  CommonResponseCode implements AbstractStateCode{

    SUCCESS(1,"操作执行成功！"),FAIL(2,"操作执行失败！");

    private long code;
    private String msg;

    CommonResponseCode(long code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
