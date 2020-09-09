package com.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @ClassName com.order.config.ResourceServerConfig
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-24 13:51
 * @Version: 1.0
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "orderServer";

    @Autowired
    TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)
                .tokenStore(tokenStore)
//            .tokenServices(tokenService()) //验证普通令牌的服务
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 配置order client 对应的接口 /order接口下所有访问控制，必须认证后才可以访问
//                .antMatchers("/order/**").access("#oauth2.hasScope('all')")
                .antMatchers("/order/**").access("#oauth2.hasScope('ROLE_ADMIN')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    /**
     * 远程调用，校验令牌服务（后面换成本地JWT校验令牌）
     * @return
     */
/*    @Bean
    public ResourceServerTokenServices tokenService() {
        RemoteTokenServices services = new RemoteTokenServices();
        services.setCheckTokenEndpointUrl("http://localhost:8082/oauth/check_token");
        services.setClientId("order");
        services.setClientSecret("123");
        return services;
    }*/

}
