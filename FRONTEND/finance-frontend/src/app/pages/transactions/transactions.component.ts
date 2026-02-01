import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TransactionService, Transaction } from '../../core/services/transaction-service';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent {

  transactions: Transaction[] = [];

  description = '';
  amount!: number;
  category = '';
  type: 'INCOME' | 'EXPENSE' = 'INCOME';

  constructor(private transactionService: TransactionService) {
    this.transactions = this.transactionService.getAll();
  }

  addTransaction(): void {
    if (!this.description || !this.amount || !this.category) {
      return;
    }

    this.transactionService.add({
      description: this.description,
      amount: this.amount,
      category: this.category,
      type: this.type,
      date: new Date().toISOString().split('T')[0]
    });

    this.transactions = this.transactionService.getAll();

    this.description = '';
    this.amount = 0;
    this.category = '';
    this.type = 'INCOME';
  }
}
