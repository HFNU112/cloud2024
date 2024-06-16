package com.at.cloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * @author shunpeng.hu
 * @date 2024/6/14 16:22
 */
@Slf4j
public class TestNacosSecretUtil {

    @Test
    @DisplayName(value = "nacos密钥")
    public void testNacosSecretGenerator(){
        // 自定义生成JWT令牌的密钥
        String nacosSecret = "nacos_secretkey_adminstrator_auth_token";
        // 输出密钥长度，要求不得低于32字符，否则无法启动节点。
        log.info("密钥长度:{}", nacosSecret.length());
        // 密钥进行Base64编码
        byte[] data = nacosSecret.getBytes(StandardCharsets.UTF_8);
        log.info("密钥Base64编码:{}", Base64Utils.encodeToString(data));
    }
}
