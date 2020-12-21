package com.rocship.alisecurity.config.shiro;/**
 * Description: <br/>
 * date: 2020/12/21 11:16<br/>
 *
 * @version
 */

import com.alicommon.lettercheck.LetterChainCheck;
import com.rocship.alisecurity.config.shiro.realm.UserRealm;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ShiroConfig <br/>
 * Description: <br/>
 * date: 2020/12/21 11:16<br/>
 * @author 15438<br />
 */
@Configuration
public class ShiroConfig {

    private static Map<String, String> synchronizedMap;

    static{
        synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        ClassPathResource pathResource = new ClassPathResource("whiteItem.properties");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pathResource.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                line = line.trim();
                if(Strings.isNotBlank(line)){
                    if(LetterChainCheck.isLetterOfCheckPath(line)){
                        synchronizedMap.put(line,"anon");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Bean
    @ConditionalOnProperty(prefix = "shiroConfig.single",value = "enable", havingValue = "one")
    public DefaultWebSessionManager defaultWebSessionManager(@Value("${shiroConfig.sessionTimeout:120}") long sessionTimeout){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(true);
        defaultWebSessionManager.setSessionValidationInterval(sessionTimeout * 1000);
        defaultWebSessionManager.setGlobalSessionTimeout(sessionTimeout * 100);
        return defaultWebSessionManager;
    }

    @Bean
    @ConditionalOnProperty(prefix = "shiroConfig.single",value = "enable",havingValue = "any")
    public ServletContainerSessionManager sessionManager(){
        ServletContainerSessionManager servletContainerSessionManager = new ServletContainerSessionManager();
        return servletContainerSessionManager;
    }


    @Bean("securityManager")
    public SecurityManager securityManager(UserRealm userRealm,UserSubjectDAO userSubjectDAO , SessionManager sessionManager){
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setSessionManager(sessionManager);
        defaultSecurityManager.setRealm(userRealm);
        defaultSecurityManager.setSubjectDAO(userSubjectDAO);
        return defaultSecurityManager;
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(synchronizedMap);
        return shiroFilterFactoryBean;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
