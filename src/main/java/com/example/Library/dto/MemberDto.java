package com.example.Library.dto;

import com.example.Library.enums.LoanStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class MemberDto {
    private String username;
    private String email;
    private String role;
    private Set<Loan> loan;

    @Getter
    @Setter
    public static class Loan{
        private LocalDateTime issueDate;
        private LocalDateTime dueDate;
        private LocalDateTime returnDate;
        private LoanStatus status;
    }
}
