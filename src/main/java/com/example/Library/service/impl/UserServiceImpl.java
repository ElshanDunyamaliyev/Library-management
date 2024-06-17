package com.example.Library.service.impl;

import com.example.Library.entity.Member;
import com.example.Library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    public void saveCustomer(@RequestBody Member user) {
        userRepository.save(user);
    }
}
