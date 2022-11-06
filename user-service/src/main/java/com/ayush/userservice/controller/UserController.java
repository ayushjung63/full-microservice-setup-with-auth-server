package com.ayush.userservice.controller;

import com.ayush.userservice.repo.UserRepo;
import com.ayush.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("/account-details/{userId}")
    private ResponseEntity fetchAccountDetailByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(
                successResponse("Account detail fetched",userService.getAccountDetailByUserId(userId))
        );
    }
}
