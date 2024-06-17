package com.example.Library.service.impl;

import com.example.Library.dto.LoanDto;
import com.example.Library.entity.Loan;
import com.example.Library.enums.LoanStatus;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.LoanMapper;
import com.example.Library.repository.LoanRepository;
import com.example.Library.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    public List<LoanDto> getAllLoans() {
        log.info("ActionLog.getAllLoans.start");
        var loans = loanRepository.findAll().stream()
                .map(loanMapper::mapToDto)
                .collect(Collectors.toList());
        log.info("ActionLog.getAllLoans.end");
        return loans;
    }

    @Override
    public LoanDto getLoanById(Long id) {
        log.info("ActionLog.getLoanById.start");
        var loan = loanMapper.mapToDto(loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan Not Found")));
        log.info("ActionLog.getLoanById.end");
        return loan;
    }

    @Override
    public LoanDto issueLoan(LoanDto loanDto) {
        log.info("ActionLog.issueLoan.start");
        Loan loan = loanMapper.mapToEntity(loanDto);
        loan.setStatus(LoanStatus.ISSUED);
        loan.setIssueDate(LocalDateTime.now());
        loan.setDueDate(LocalDateTime.now().plusWeeks(2));
        loanRepository.save(loan);
        log.info("ActionLog.issueLoan.end");
        return loanMapper.mapToDto(loan);
    }

    @Override
    public LoanDto returnLoan(Long id, LocalDateTime returnDate) {
        log.info("ActionLog.returnLoan.start");
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan Not Found"));
        loan.setReturnDate(returnDate);
        loan.setStatus(LoanStatus.RETURNED);
        loanRepository.save(loan);
        log.info("ActionLog.returnLoan.start");
        return loanMapper.mapToDto(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        log.info("ActionLog.deleteLoan.start");
        loanRepository.deleteById(id);
        log.info("ActionLog.deleteLoan.end");
    }
}
