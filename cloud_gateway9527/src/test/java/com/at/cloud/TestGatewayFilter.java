package com.at.cloud;

import com.at.cloud.constant.SystemConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author shunpeng.hu
 * @date 2024/6/6 14:11
 */
@SpringBootTest(classes = CloudGatewayApplication9527.class)
public class TestGatewayFilter {

    @Test
    @DisplayName(value = "Gateway内置过滤器测试通过")
    public void testGetGatewayFilter(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Request-atValue1", "value1");
        headers.set("X-Request-atValue2", "value2");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = new RestTemplate()
                .exchange(SystemConstant.GATEWAY_BASE_URL + "/provider/pay/gateway/filter", HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.OK.value() + " " + HttpStatus.OK.getReasonPhrase(), response.getStatusCode().toString());
        Assertions.assertTrue(Objects.requireNonNull(response.getBody()).contains("getGatewayFilter 过滤器 test"));
    }
}
