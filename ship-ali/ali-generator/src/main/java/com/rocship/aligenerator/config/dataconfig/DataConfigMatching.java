package com.rocship.aligenerator.config.dataconfig;/**
 * Description: <br/>
 * date: 2021/1/5 17:50<br/>
 *
 * @version
 */

import com.rocship.aligenerator.dao.MysqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * ClassName: DataConfigMatching <br/>
 * Description: <br/>
 * date: 2021/1/5 17:50<br/>
 * @author 15438<br />
 */
@Configuration
public class DataConfigMatching {

    @Value("${runtime.datasource:mysql}")
    private String dataSourseType;

    @Resource
    private MysqlDao mysqlDao;

    @Bean
    @Primary
    public AbstractDao matchingDao(){
        switch (dataSourseType){
            case "mysql":
                return mysqlDao;
            case "oracle":
                return null;
            case "mogonDB":
                return null;
            case "sqlserver":
                return null;
            case "postgresql":
                return null;
            default:
                return null;

        }

    }


}
