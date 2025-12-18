package com.familyexpenses.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Description obligatoire")
    @Column(nullable = false)
    private String description;
    
    @NotNull(message = "Montant obligatoire")
    @Positive(message = "Le montant doit être positif")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
    
    @NotBlank(message = "Catégorie obligatoire")
    @Column(nullable = false)
    private String category;
    
    @NotNull(message = "Date obligatoire")
    @Column(nullable = false)
    private LocalDate date;
    
    @Column(name = "family_member")
    private String familyMember;
    
    @Column(name = "created_at")
    private LocalDate createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        if (date == null) {
            date = LocalDate.now();
        }
    }
}