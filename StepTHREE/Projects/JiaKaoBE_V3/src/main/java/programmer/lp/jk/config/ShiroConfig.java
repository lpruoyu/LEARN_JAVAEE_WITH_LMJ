package programmer.lp.jk.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import programmer.lp.jk.common.filter.ErrorFilter;
import programmer.lp.jk.common.properties.FileUploadProperties;
import programmer.lp.jk.common.shiro.TokenFilter;
import programmer.lp.jk.common.shiro.TokenMatcher;
import programmer.lp.jk.common.shiro.TokenRealm;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public Realm realm() {
        return new TokenRealm(new TokenMatcher());
    }

    /**
     * ShiroFilterFactoryBean用来告诉Shiro如何进行拦截
     * 1.拦截哪些URL
     * 2.每个URL需要经过哪些filter
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(Realm realm, FileUploadProperties properties) {
        ShiroFilterFactoryBean filterBean = new ShiroFilterFactoryBean();

        // 安全管理器
        filterBean.setSecurityManager(new DefaultWebSecurityManager(realm));

        // 添加一些自定义Filter
        Map<String, Filter> filters = new HashMap<>();
        filters.put("token", new TokenFilter());
        filterBean.setFilters(filters);

        // 设置URL如何拦截
        // Filter的顺序很重要，因此需要使用LinkedHashMap
        Map<String, String> urlMap = new LinkedHashMap<>();
        // 验证码
        urlMap.put("/sysUsers/captcha", "anon");
        // 用户登录
        urlMap.put("/sysUsers/login", "anon");
        // swagger
//        urlMap.put("/swagger*/**", "anon");
//        urlMap.put("/v2/api-docs/**", "anon");
        // 全局Filter的异常处理
        urlMap.put(ErrorFilter.ERROR_URI, "anon");
        // 上传的内容(/upload/**)
        urlMap.put("/" + properties.getUploadPath() + "**", "anon");
        // 其他
        urlMap.put("/**", "token");

        filterBean.setFilterChainDefinitionMap(urlMap);
        return filterBean;
    }

    /**
     * 解决：@RequiresPermissions导致控制器接口404
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator proxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setUsePrefix(true);
        return proxyCreator;
    }
}
