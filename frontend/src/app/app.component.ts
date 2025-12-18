import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ExpenseService, Expense } from './services/expense.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  expenses: Expense[] = [];
  newExpense: Expense = {
    description: '',
    amount: 0,
    category: '',
    date: new Date().toISOString().split('T')[0],
    familyMember: ''
  };

  categories = ['Alimentation', 'Transport', 'Loisirs', 'Santé', 'Logement', 'Autre'];

  constructor(private expenseService: ExpenseService) {}

  ngOnInit(): void {
    this.loadExpenses();
  }

  loadExpenses(): void {
    this.expenseService.getAllExpenses().subscribe({
      next: (data) => this.expenses = data,
      error: (err) => console.error('Erreur lors du chargement:', err)
    });
  }

  addExpense(): void {
    if (!this.newExpense.description || !this.newExpense.amount || !this.newExpense.category) {
      alert('Veuillez remplir tous les champs obligatoires');
      return;
    }

    this.expenseService.createExpense(this.newExpense).subscribe({
      next: () => {
        this.loadExpenses();
        this.resetForm();
        alert('Dépense ajoutée avec succès !');
      },
      error: (err) => console.error('Erreur lors de l\'ajout:', err)
    });
  }

  deleteExpense(id: number | undefined): void {
    if (!id) return;
    
    if (confirm('Supprimer cette dépense ?')) {
      this.expenseService.deleteExpense(id).subscribe({
        next: () => this.loadExpenses(),
        error: (err) => console.error('Erreur lors de la suppression:', err)
      });
    }
  }

  resetForm(): void {
    this.newExpense = {
      description: '',
      amount: 0,
      category: '',
      date: new Date().toISOString().split('T')[0],
      familyMember: ''
    };
  }

  getTotalExpenses(): number {
    return this.expenses.reduce((sum, exp) => sum + exp.amount, 0);
  }
}