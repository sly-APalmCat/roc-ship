package com.alicommon.lettercheck.file.utils.response;/**
 * Description: <br/>
 * date: 2021/1/7 15:19<br/>
 *
 * @version
 */

import com.alicommon.lettercheck.file.utils.response.statecode.AbstractStateCode;
import com.alicommon.lettercheck.file.utils.response.statecode.AliGeneratorStateCode;
import com.alicommon.lettercheck.file.utils.response.statecode.CommonResponseCode;
import lombok.Data;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.HashMap;

/**
 * ClassName: Res <br/>
 * Description: <br/>
 * date: 2021/1/7 15:19<br/>
 * @author 15438<br />
 */
@Data
public class Res extends HashMap<String,Object> {
    private long code;
    private String msg;
    private Object payload;

    public static Res ok(){
        return new Res().setResData(CommonResponseCode.SUCCESS);
    }

    public static Res fail(){
        return new Res().setResData(CommonResponseCode.FAIL);
    }

    public Res setResData(AbstractStateCode abstractStateCode){
        if (abstractStateCode instanceof AliGeneratorStateCode){
            AliGeneratorStateCode stateCode = (AliGeneratorStateCode) abstractStateCode;
            this.code = stateCode.getCode();
            this.msg = stateCode.getSay();
        }else if(abstractStateCode instanceof CommonResponseCode){
            CommonResponseCode code = (CommonResponseCode) abstractStateCode;
            this.code = code.getCode();
            this.msg = code.getMsg();
        }else {}
        return this;
    }


    @Override
    public Res put(String key, Object val){
        super.put(key,val);
        return this;
    }




}
