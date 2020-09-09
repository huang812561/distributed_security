package com.hgq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ClassName com.hgq.config.TokenConfig
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-09-07 11:18
 * @Version: 1.0
 */
@Configuration
public class TokenConfig {

    private final static String SIGNING_KEY = "admin123";

/*    @Bean
    public TokenStore tokenStore() {
        //使用内存存储令牌（普通令牌）
        return new InMemoryTokenStore();
    }*/

    @Bean
    public TokenStore tokenStore(){
        //JWT令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);   //对称秘钥，资源服务器使用该秘钥来验证
        return converter;
    }
}
