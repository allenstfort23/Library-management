package com.librarymanagement.librarymanagement.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MemberDto {
    private Long id;
    private String email;
    @NotEmpty(message = "First name should not be empty")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty")
    private String lastName;
    private String memberId;
    private String book;
    private String photoUrl;
    private String author;
    private String bookId;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
