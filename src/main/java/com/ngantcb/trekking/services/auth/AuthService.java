package com.ngantcb.trekking.services.auth;

import com.ngantcb.trekking.dto.RegisterRequest;
import com.ngantcb.trekking.dto.UserDto;

public interface AuthService {

    UserDto createUser(RegisterRequest registerRequest);

    boolean hasUserWithEmail(String email);
}
