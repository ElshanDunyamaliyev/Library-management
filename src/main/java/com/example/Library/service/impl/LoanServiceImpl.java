package com.example.Library.service.impl;

import com.example.Library.dto.LoanDto;
import com.example.Library.entity.Loan;
import com.example.Library.enums.LoanStatus;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.LoanMapper;
import com.example.Library.repository.LoanRepository;
import com.example.Library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    public List<LoanDto> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(loanMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LoanDto getLoanById(Long id) {
        return loanMapper.mapToDto(loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan Not Found")));
    }

    @Override
    public LoanDto issueLoan(LoanDto loanDto) {
        Loan loan = loanMapper.mapToEntity(loanDto);
        loan.setStatus(LoanStatus.ISSUED);
        loan.setIssueDate(LocalDateTime.now());
        loan.setDueDate(LocalDateTime.now().plusWeeks(2));
        loanRepository.save(loan);
        return loanMapper.mapToDto(loan);
    }

    @Override
    public LoanDto returnLoan(Long id, LocalDateTime returnDate) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan Not Found"));
        loan.setReturnDate(returnDate);
        loan.setStatus(LoanStatus.RETURNED);
        loanRepository.save(loan);
        return loanMapper.mapToDto(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
