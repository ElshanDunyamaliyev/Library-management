package com.example.Library.controller;

import com.example.Library.dto.LoanDto;
import com.example.Library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    public List<LoanDto> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public LoanDto getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @PostMapping
    public LoanDto issueLoan(@RequestBody LoanDto loanDto) {
        return loanService.issueLoan(loanDto);
    }

    @PutMapping("/{id}/return")
    public LoanDto returnLoan(@PathVariable Long id, @RequestParam("returnDate") LocalDateTime returnDate) {
        return loanService.returnLoan(id, returnDate);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}

