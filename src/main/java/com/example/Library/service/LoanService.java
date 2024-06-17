package com.example.Library.service;

import com.example.Library.dto.LoanDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LoanService {
    List<LoanDto> getAllLoans();
    LoanDto getLoanById(Long id);
    LoanDto issueLoan(LoanDto loanDto);
    LoanDto returnLoan(Long id, LocalDateTime returnDate);
    void deleteLoan(Long id);
}
