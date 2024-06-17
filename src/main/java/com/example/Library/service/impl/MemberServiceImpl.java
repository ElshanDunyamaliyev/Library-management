package com.example.Library.service.impl;

import com.example.Library.entity.Member;
import com.example.Library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl {

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        log.info("ActionLog.getAllMembers.start");
        List<Member> members = memberRepository.findAll();
        log.info("ActionLog.getAllMembers.end");
        return members;
    }

    public void saveMember(@RequestBody Member member) {
        log.info("ActionLog.saveMember.start");
        memberRepository.save(member);
        log.info("ActionLog.saveMember.end");
    }

    public void deleteMemberById(Long id) {
        log.info("ActionLog.deleteMember.start");
        memberRepository.deleteById(id);
        log.info("ActionLog.deleteMember.end");
    }
}
