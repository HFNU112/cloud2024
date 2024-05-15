package com.at.cloud;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @author: shunpeng.hu
 * @date: 2024/5/14 16:11
 */
@SpringBootTest
public class ZonedDateTimeDemoTest {

    @Test
    @DisplayName(value = "获取默认时区")
    public void testzoneDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);  //2024-05-14T16:15:19.666989600+08:00[Asia/Shanghai]
    }
}
