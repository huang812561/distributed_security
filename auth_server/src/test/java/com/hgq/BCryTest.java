package com.hgq;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName com.hgq.BCryTest
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-09-07 20:00
 * @Version: 1.0
 */
public class BCryTest {

    @Test
    public void test(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwod = passwordEncoder.encode("123");
        System.out.println(passwod);
    }
}
