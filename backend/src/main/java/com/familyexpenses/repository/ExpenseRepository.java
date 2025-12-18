package com.familyexpenses.repository;

import com.familyexpenses.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Expense> findByCategory(String category);
    
    @Query("SELECT e.category as category, SUM(e.amount) as total FROM Expense e GROUP BY e.category")
    List<Map<String, Object>> getTotalByCategory();
    
    @Query("SELECT e.familyMember as member, SUM(e.amount) as total FROM Expense e GROUP BY e.familyMember")
    List<Map<String, Object>> getTotalByFamilyMember();
}