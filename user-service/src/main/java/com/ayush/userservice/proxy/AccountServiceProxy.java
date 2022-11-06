package com.ayush.userservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountServiceProxy {

    @GetMapping("account/user-id/{userId}")
    ResponseEntity fetchAccountDetailByUserId(@PathVariable("userId") Long userId);
}
