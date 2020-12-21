package com.rocship.alisecurity.config.kaptcha;/**
 * Description: <br/>
 * date: 2020/12/21 14:49<br/>
 *
 * @version
 */

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.Random;

/**
 * ClassName: KaptChaConfig <br/>
 * Description: <br/>
 * date: 2020/12/21 14:49<br/>
 * @author 15438<br />
 */
@Configuration
public class KaptChaConfig {


    @Bean
   public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
       defaultKaptcha.setConfig(getKaptchaColor());
        return defaultKaptcha;
   }

   public static Config getKaptchaColor(){
       Properties properties = new Properties();
       properties.put(Constants.KAPTCHA_BORDER,"no");
       Random random = new Random();
       int flag = random.nextInt(10);
       int s = random.nextInt(256) | flag;
       int r = random.nextInt(256) | (flag / 3);
       int g = random.nextInt(256) | (flag / 2);
       int b = random.nextInt(256) | flag;
       StringBuilder builder = new StringBuilder();
       builder.append(s).append(",").append(r).append(",").append(g).append(",")
               .append(b);
       properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR,builder.toString());
       properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE,"6");
       properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES,"Arial,Courier,cmr10,楷体,宋体,微软雅黑");
       return new Config(properties);
   }
}
