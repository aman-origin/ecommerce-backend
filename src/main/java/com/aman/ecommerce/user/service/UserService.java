package com.aman.ecommerce.user.service;

import com.aman.ecommerce.user.dto.RegisterUserRequest;
import com.aman.ecommerce.user.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest request);

}