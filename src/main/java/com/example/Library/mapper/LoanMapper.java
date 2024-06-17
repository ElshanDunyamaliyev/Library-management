package com.example.Library.mapper;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.LoanDto;
import com.example.Library.entity.Book;
import com.example.Library.entity.Loan;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan mapToEntity(LoanDto loanDto);
    LoanDto mapToDto(Loan loan);
}
