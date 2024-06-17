package com.example.Library.service.impl;

import com.example.Library.entity.Member;
import com.example.Library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl {

    private final MemberRepository memberRepository;

    public void saveCustomer(@RequestBody Member member) {
        memberRepository.save(member);
    }
}
