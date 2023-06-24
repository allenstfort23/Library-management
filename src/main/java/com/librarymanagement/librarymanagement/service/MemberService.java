package com.librarymanagement.librarymanagement.service;

import com.librarymanagement.librarymanagement.dto.MemberDto;

import java.util.List;

public interface MemberService {
    List<MemberDto> findByMemberId();
}
