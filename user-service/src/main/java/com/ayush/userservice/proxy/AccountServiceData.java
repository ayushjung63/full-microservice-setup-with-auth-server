package com.ayush.userservice.proxy;

import com.ayush.userservice.GlobalApiResponse;
import com.ayush.userservice.entity.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class AccountServiceData {
    private final AccountServiceProxy accountServiceProxy;
    private final ObjectMapper objectMapper;

    public List<Account> fetchAccountDetailByUserId(Long userId){
        ResponseEntity responseEntity = accountServiceProxy.fetchAccountDetailByUserId(userId);
        GlobalApiResponse globalApiResponse = objectMapper.convertValue(responseEntity.getBody(), GlobalApiResponse.class);
        return (List<Account>) globalApiResponse.getData();
    }
}
