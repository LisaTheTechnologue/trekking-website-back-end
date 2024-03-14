package com.ngantcb.trekking.services.auth;

import com.ngantcb.trekking.dto.RegisterRequest;
import com.ngantcb.trekking.dto.UserDto;
import com.ngantcb.trekking.entity.User;
import com.ngantcb.trekking.enums.UserRole;
import com.ngantcb.trekking.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setFirstName(registerRequest.getFName());
        user.setLastName(registerRequest.getLName());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        user.formatData();
        User createdUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if(null == adminAccount) {
            User user = new User();
            user.setEmail("admin@email.com");
            user.setLastName("admin");
            user.setFirstName("admin");
            user.setRole(UserRole.ADMIN);
            user.setIsActive(true);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
}
