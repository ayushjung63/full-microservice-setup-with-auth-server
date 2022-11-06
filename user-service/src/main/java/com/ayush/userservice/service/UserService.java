package com.ayush.userservice.service;

import java.util.*;
import com.ayush.userservice.pojos.ResponsePojo;

public interface UserService {
    List<ResponsePojo> getAccountDetailByUserId(Long userId);
}
