package com.alicommon.lettercheck.file.utils.request.config;/**
 * Description: <br/>
 * date: 2021/1/5 11:44<br/>
 *
 * @version
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * ClassName: RequestConfig <br/>
 * Description: <br/>
 * date: 2021/1/5 11:44<br/>
 * @author 15438<br />
 */
@Configuration
public class RequestConfig {

    public static RestTemplate utillsRestTemplate = null;

    @Bean
    @ConditionalOnMissingBean(type = "restTemplate")
    @Order(1)
    public RestTemplate restTemplate(){
        RestTemplate restTemplate2 = new RestTemplate();
        if(ObjectUtils.isEmpty(RequestConfig.utillsRestTemplate)){
            RequestConfig.utillsRestTemplate = restTemplate2;
        }
        return restTemplate2;
    }

    @Autowired
    @Order(2)
    private RestTemplate restTemplate;

    @PostConstruct
    @Order(3)
    public void valuationUtilRestTemplate(){
        RequestConfig.utillsRestTemplate = restTemplate;
    }


}
