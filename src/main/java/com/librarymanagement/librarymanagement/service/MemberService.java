package com.librarymanagement.librarymanagement.service;

import com.librarymanagement.librarymanagement.dto.MemberDto;
import com.librarymanagement.librarymanagement.model.Member;

import java.util.List;

public interface MemberService {
    List<MemberDto> findByMemberId();

    void saveMember(Member member);
}
