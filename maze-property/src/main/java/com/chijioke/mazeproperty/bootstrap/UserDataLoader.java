package com.chijioke.mazeproperty.bootstrap;

import com.chijioke.mazeproperty.constant.UserRole;
import com.chijioke.mazeproperty.model.UserInfo;
import com.chijioke.mazeproperty.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (userInfoRepository.count() == 0){
            UserInfo userInfo1 = UserInfo.builder()
                    .email("user1@mail.com")
                    .name("user1")
                    .password(passwordEncoder.encode("Pwd1"))
                    .roles(UserRole.concatenate(Arrays.asList(UserRole.USER, UserRole.ADMIN)))
                    .build();
            UserInfo userInfo2 = UserInfo.builder()
                    .email("user2@mail.com")
                    .name("user2")
                    .password(passwordEncoder.encode("Pwd2"))
                    .roles(UserRole.concatenate(Arrays.asList(UserRole.USER)))
                    .build();
            UserInfo userInfo3 = UserInfo.builder()
                    .email("user3@mail.com")
                    .name("user3")
                    .password(passwordEncoder.encode("Pwd3"))
                    .roles(UserRole.concatenate(Arrays.asList(UserRole.ADMIN)))
                    .build();

            userInfoRepository.saveAll(Arrays.asList(userInfo1, userInfo2, userInfo3));
        }
    }
}
