package com.ayush.userservice.service.impl;

import com.ayush.userservice.entity.Account;
import com.ayush.userservice.entity.User;
import com.ayush.userservice.pojos.ResponsePojo;
import com.ayush.userservice.proxy.AccountServiceData;
import com.ayush.userservice.proxy.AccountServiceProxy;
import com.ayush.userservice.repo.UserRepo;
import com.ayush.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final AccountServiceData accountServiceData;

    @Override
    public List<ResponsePojo> getAccountDetailByUserId(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        List<Account> accountList = accountServiceData.fetchAccountDetailByUserId(userId);
        List<ResponsePojo> responsePojos=new ArrayList<>();
        for (Account a :accountList){
            responsePojos.add(
                    ResponsePojo.builder()
                            .id(a.getId())
                            .amountPaid(a.getAmountPaid())
                            .name(user.getName())
                            .build()
            );
        }
        return responsePojos;
    }
}
