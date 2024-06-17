package com.example.Library.controller;

import com.example.Library.dto.LoanDto;
import com.example.Library.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @Operation(
            summary = "Getting all Loans",
            description = "REST API to Getting all loans"
    )
    @GetMapping
    public List<LoanDto> getAllLoans() {
        return loanService.getAllLoans();
    }

    @Operation(
            summary = "Getting all Loan by id"
    )
    @GetMapping("/{id}")
    public LoanDto getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @Operation(
            summary = "Creating Loan"
    )
    @PostMapping
    public LoanDto issueLoan(@RequestBody LoanDto loanDto) {
        return loanService.issueLoan(loanDto);
    }

    @Operation(
            summary = "Returning Loan by id"
    )
    @PutMapping("/{id}/return")
    public LoanDto returnLoan(@PathVariable Long id, @RequestParam("returnDate") LocalDateTime returnDate) {
        return loanService.returnLoan(id, returnDate);
    }

    @Operation(
            summary = "Deleting Loan by id"
    )
    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}

