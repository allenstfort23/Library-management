package com.librarymanagement.librarymanagement.service.Impl;

import com.librarymanagement.librarymanagement.dto.MemberDto;
import com.librarymanagement.librarymanagement.model.Member;
import com.librarymanagement.librarymanagement.repository.MemberRepository;
import com.librarymanagement.librarymanagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> findByMemberId() {
       List<Member> members = memberRepository.findAll();
       return members.stream().map(member -> mapToMemberDto(member)).collect(Collectors.toList());
    }

    private MemberDto mapToMemberDto(Member member){
        MemberDto memberDto = MemberDto.builder()
                .id(member.getId())
                .memberId(member.getMemberId())
                .book(member.getBook())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .createdOn(member.getCreatedOn())
                .updateOn(member.getUpdateOn())
                .photoUrl(member.getPhotoUrl())
                .build();
        return memberDto;
    }
}