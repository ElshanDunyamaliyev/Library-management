package com.example.Library.dto;

import com.example.Library.enums.LoanStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanDto {

    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private LoanStatus status;
    private Member member;
    private Book book;

    @Getter
    @Setter
    public static class Member{
        private String username;
        private String email;
        private String role;
    }
}


