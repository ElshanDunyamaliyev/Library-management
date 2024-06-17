package com.example.Library.controller;

import com.example.Library.entity.Member;
import com.example.Library.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/member")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody Member user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        memberService.saveMember(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/member/{memberId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Member> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    };
}
