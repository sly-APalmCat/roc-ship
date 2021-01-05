package com.alicommon.lettercheck.file.utils.request;/**
 * Description: <br/>
 * date: 2021/1/5 11:19<br/>
 *
 * @version
 */

import com.alicommon.lettercheck.file.utils.request.config.RequestConfig;
import com.alicommon.lettercheck.file.utils.request.requestexcution.RequestExcution;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

/**
 * ClassName: RequestFunction <br/>
 * Description: <br/>
 * date: 2021/1/5 11:19<br/>
 * @author 15438<br />
 */
public class RequestFunction implements Function<RequestExcution,HttpEntity> {

    protected RestTemplate restTemplate = RequestConfig.utillsRestTemplate;

    @Override
    public HttpEntity apply(RequestExcution requestExcution) {

        if(HttpMethod.POST.matches(requestExcution.getMethod().name())){
           return postExcution(restTemplate,requestExcution);
        }else {
            return getExcution(restTemplate,requestExcution);
        }
    }

    private HttpEntity getExcution(RestTemplate restTemplate, RequestExcution requestExcution) {
        return restTemplate.getForObject(requestExcution.getUrlAndParam(),HttpEntity.class);

    }

    private HttpEntity postExcution(RestTemplate restTemplate, RequestExcution requestExcution) {
        return  restTemplate.postForObject(requestExcution.getUrlAndParam(),requestExcution.getPlayload(),HttpEntity.class);
    }
}
