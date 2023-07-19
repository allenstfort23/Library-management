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
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> findByMember() {
       List<Member> members = memberRepository.findAll();
       return members.stream().map(member -> mapToMemberDto(member)).collect(Collectors.toList());
    }

    @Override
    public void saveMember(MemberDto memberDto) {
        Member member = mapToMember(memberDto);
        memberRepository.save(member);
    }


    @Override
    public MemberDto findByMemberId(long memberId) {
        Member member = memberRepository.findById(memberId).get();
        return mapToMemberDto(member);
    }

    @Override
    public void updateMember(MemberDto memberDto) {
      Member member = mapToMember(memberDto);
      memberRepository.save(member);
    }

    private Member mapToMember(MemberDto member) {
        return Member.builder()
                .id(member.getId())
                .memberId(member.getMemberId())
                .book(member.getBook())
                .bookId(member.getBookId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .createdOn(member.getCreatedOn())
                .updateOn(member.getUpdateOn())
                .photoUrl(member.getPhotoUrl())
                .email(member.getEmail())
                .author(member.getAuthor())
                .build();
    }


    private MemberDto mapToMemberDto(Member member){
        return MemberDto.builder()
                .id(member.getId())
                .memberId(member.getMemberId())
                .book(member.getBook())
                .bookId(member.getBookId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .createdOn(member.getCreatedOn())
                .updateOn(member.getUpdateOn())
                .photoUrl(member.getPhotoUrl())
                .email(member.getEmail())
                .author(member.getAuthor())
                .build();
    }
}
