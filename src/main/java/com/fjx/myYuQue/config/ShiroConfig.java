package com.fjx.myYuQue.config;

import java.util.LinkedHashMap;

// import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        /*
            anon：   无需认证就可以访问
            authc：  必须认证了才能访问
            user：   必须拥有 记住我 功能才能使用
            perms：  拥有某个资源的权限才能访问
            role：   拥有某个角色权限才能访问
        */
        //定义拦截链
        LinkedHashMap<String, String> filtermap = new LinkedHashMap<>();

        // 配置不会被拦截的链接 顺序判断
        filtermap.put("*.html", "anon");
        filtermap.put("/loginCheck", "anon");
        filtermap.put("/loginCheck", "anon");
        filtermap.put("/login", "anon");
        filtermap.put("/register", "anon");
        filtermap.put("/index", "authc");
        filtermap.put("/changeDoc", "authc");
        filtermap.put("/editormd", "authc");
        filtermap.put("/viewDoc", "authc");
        filtermap.put("/viewDocs", "authc");
        filtermap.put("/viewTags", "authc");
        filtermap.put("/tag", "authc");
        
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filtermap.put("/logout", "logout");

        factoryBean.setFilterChainDefinitionMap(filtermap);

        //设置登录要跳转的链接
        //如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        factoryBean.setLoginUrl("/login");
        //设置成功后要跳转的链接
        factoryBean.setSuccessUrl("/index");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("/noauth");

        return factoryBean;

    }

    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    

}
