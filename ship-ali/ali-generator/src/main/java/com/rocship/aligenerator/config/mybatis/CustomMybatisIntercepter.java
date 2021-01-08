package com.rocship.aligenerator.config.mybatis;/**
 * Description: <br/>
 * date: 2021/1/7 17:14<br/>
 *
 * @version
 */

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * ClassName: CustomMybatisIntercepter <br/>
 * Description: <br/>
 * date: 2021/1/7 17:14<br/>
 * @author 15438<br />
 */
@Component
@Order(1)
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
)})
public class CustomMybatisIntercepter implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof DefaultResultSetHandler){
            DefaultResultSetHandler handler = (DefaultResultSetHandler) target;
            System.out.println("===");
        }else if(target instanceof DefaultParameterHandler){
            DefaultParameterHandler handler = (DefaultParameterHandler) target;
            System.out.println("===");
        }
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("=====================================================");
    }
}
