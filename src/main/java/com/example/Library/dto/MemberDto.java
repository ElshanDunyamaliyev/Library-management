package com.example.Library.dto;

import com.example.Library.enums.LoanStatus;
import com.example.Library.enums.MemberRole;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class MemberDto {
    @NotEmpty(message = "Username can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the author's first name should be between 5 and 30")
    private String username;
    @Email
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
