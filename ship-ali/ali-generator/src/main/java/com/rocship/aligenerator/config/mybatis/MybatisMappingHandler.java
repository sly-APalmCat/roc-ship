package com.rocship.aligenerator.config.mybatis;/**
 * Description: <br/>
 * date: 2021/1/7 17:03<br/>
 *
 * @version
 */

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 *针对sql中的某一列做自定义 操作
 * todo 无用
 * ClassName: MybatisMappingHandler <br/>
 * Description: <br/>
 * date: 2021/1/7 17:03<br/>
 * @author 15438<br />
 */
public class MybatisMappingHandler implements ResultHandler<Object> {
    @Override
    public void handleResult(ResultContext<? extends Object> resultContext) {
        System.out.println("-----");
    }
}
