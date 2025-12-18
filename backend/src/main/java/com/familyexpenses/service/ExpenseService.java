package com.familyexpenses.service;

import com.familyexpenses.model.Expense;
import com.familyexpenses.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }
    
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    
    public Expense updateExpense(Long id, Expense expenseDetails) {
        Expense expense = expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Dépense non trouvée avec l'id : " + id));
        expense.setDescription(expenseDetails.getDescription());
        expense.setAmount(expenseDetails.getAmount());
        expense.setCategory(expenseDetails.getCategory());
        expense.setDate(expenseDetails.getDate());
        expense.setFamilyMember(expenseDetails.getFamilyMember());
        return expenseRepository.save(expense);
    }
    
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
    
    public List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByDateBetween(startDate, endDate);
    }
    
    public List<Map<String, Object>> getStatsByCategory() {
        return expenseRepository.getTotalByCategory();
    }
    
    public List<Map<String, Object>> getStatsByFamilyMember() {
        return expenseRepository.getTotalByFamilyMember();
    }
}