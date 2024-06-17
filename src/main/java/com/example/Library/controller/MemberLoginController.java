package com.example.Library.controller;

import com.example.Library.entity.Member;
import com.example.Library.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberServiceImpl memberService;
//    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody Member user) {
//        String password = passwordEncoder.encode(user.getPassword());
//        user.setPassword(password);
        memberService.saveCustomer(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
