package com.example.authservice.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "STOCK")
public interface UserCallableApi {
}