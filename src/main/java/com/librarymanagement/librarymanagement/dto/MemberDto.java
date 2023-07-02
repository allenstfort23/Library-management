package com.librarymanagement.librarymanagement.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MemberDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String memberId;
    private String book;
    private String photoUrl;
    private String author;
    private String bookId;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
