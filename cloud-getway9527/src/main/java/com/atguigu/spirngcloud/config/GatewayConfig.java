package com.atguigu.spirngcloud.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huazai
 * @description 限流处理， 参考地址https://www.bilibili.com/video/BV15U4y1i7hb?p=82&vd_source=ab0d7f31ecb77d9df82fa8718614ac91
 * 其他的资料上不好找这个， 只有在这个视频里看到这个 暂时
 * @date 2022/8/2
 */
@Configuration
public class GatewayConfig {

    @PostConstruct
    public void init() {
        BlockRequestHandler blockRequestHandler = (serverWebExchange, throwable) -> {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("code", HttpStatus.TOO_MANY_REQUESTS.toString());
            resMap.put("message", "限流了");
            return ServerResponse.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(resMap));
        };

        GatewayCallbackManager.setBlockHandler(blockRequestHandler);

    }
}
