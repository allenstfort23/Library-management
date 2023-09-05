package com.librarymanagement.librarymanagement.service;

import com.librarymanagement.librarymanagement.dto.MemberDto;
import com.librarymanagement.librarymanagement.model.Member;

import java.util.List;

public interface MemberService {
    List<MemberDto> findAllMembers();

    void saveMember(MemberDto memberDto);

    MemberDto findByMemberId(long memberId);


    void updateMember(MemberDto member);
}
