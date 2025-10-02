package com.moodify.Service;

import com.moodify.Mapper.UserMapper;
import com.moodify.Model.User;
import com.moodify.Repository.UserRepository;
import com.moodify.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse save(User userEntity){
        String password = userEntity.getPassword();
        userEntity.setPassword(passwordEncoder.encode(password));

        User saved = userRepository.save(userEntity);
        UserResponse response = UserMapper.toUserResponse(saved);
        return response;
    }
}
