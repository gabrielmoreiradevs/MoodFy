package com.moodify.Mapper;

import com.moodify.Model.User;
import com.moodify.request.UserRequest;
import com.moodify.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .password(userRequest.password())
                .email(userRequest.email())
                .build();
    }

    public static UserResponse toUserResponse(User userEntity){
        return UserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }
}
