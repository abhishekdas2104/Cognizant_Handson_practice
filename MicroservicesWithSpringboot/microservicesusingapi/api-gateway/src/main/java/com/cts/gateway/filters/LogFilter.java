package com.cts.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Request URI: " + exchange.getRequest().getURI());
        System.out.println("Request Method: " + exchange.getRequest().getMethod());
        System.out.println("Request Path: " + exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
