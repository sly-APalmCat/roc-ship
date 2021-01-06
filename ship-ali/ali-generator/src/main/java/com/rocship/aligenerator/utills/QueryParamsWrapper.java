package com.rocship.aligenerator.utills;/**
 * Description: <br/>
 * date: 2021/1/6 10:46<br/>
 *
 * @version
 */

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName: QueryParamsWrapper <br/>
 * Description: <br/>
 * date: 2021/1/6 10:46<br/>
 * @author 15438<br />
 */
@Data
public class QueryParamsWrapper extends LinkedHashMap<String,Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int limit;
    private int page;

    public QueryParamsWrapper(Map<String,Object> paramsWrapper){
        this.putAll(paramsWrapper);
        this.limit = Integer.parseInt(paramsWrapper.get("limit").toString());
        this.page = Integer.parseInt(paramsWrapper.get("page").toString());
        this.put("limit",limit);
        this.put("page",page);
        this.put("offset",(page-1) * limit);
    }



}
