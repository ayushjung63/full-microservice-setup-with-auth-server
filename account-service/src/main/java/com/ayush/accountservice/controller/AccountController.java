package com.ayush.accountservice.controller;

import com.ayush.accountservice.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController extends BaseController {

    private final AccountRepo accountRepo;

    @GetMapping("/user-id/{userId}")
    private ResponseEntity fetchAccountDetailByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(
                successResponse("Account detail fetched",accountRepo.findByUserId(userId))
        );
    }
}
