package com.example.Library.entity;

import com.example.Library.enums.MemberRole;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    private String username;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "member")
    private Set<Loan> loan;
}
