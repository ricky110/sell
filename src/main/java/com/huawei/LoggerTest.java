package com.huawei;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Ricky
 * @Date: 2019-09-22 16:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){

        String name = "huawei";
        String password = "124";

        log.debug("debug...");
        log.info("name: " + name + ", " + "password: " + password);
        log.info("name: {},password: {}", name, password);
        log.error("error...");
        log.warn("warn...");

    }

}
