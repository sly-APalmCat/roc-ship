package com.alicommon.lettercheck.file.utils.request.requestexcution;/**
 * Description: <br/>
 * date: 2021/1/5 11:27<br/>
 *
 * @version
 */

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;

/**
 * ClassName: RequestExcution <br/>
 * Description: <br/>
 * date: 2021/1/5 11:27<br/>
 * @author 15438<br />
 */
@Builder
@Data
public class RequestExcution {

    private HttpMethod method;
    private String urlAndParam;
    private Object playload;

}
