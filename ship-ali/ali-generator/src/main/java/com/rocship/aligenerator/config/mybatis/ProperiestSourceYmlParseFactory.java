package com.rocship.aligenerator.config.mybatis;/**
 * Description: <br/>
 * date: 2021/1/13 10:53<br/>
 *
 * @version
 */

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * ClassName: ProperiestSourceYmlParseFactory <br/>
 * Description: 此处方法是处理自定义yaml 、yml 文件时，使用@PropertySource(value="*.yml" ,factory = ProperiestSourceYmlParseFactory.class)  注解产生结果，可以一下实现方式指定解析工厂<br/>
 * date: 2021/1/13 10:53<br/>
 * @author 15438<br />
 */
public class ProperiestSourceYmlParseFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        name = Optional.ofNullable(name).orElseGet(()-> resource.getResource().getFilename());
        if(name.endsWith("yaml") || name.endsWith("yml")){
            List<PropertySource<?>> load = new YamlPropertySourceLoader().load(name, resource.getResource());
            return Optional.ofNullable(load.get(0)).orElse(null);
        }
        return (name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource));
    }
}
