import { Injectable } from '@angular/core';

export interface Transaction {
  description: string;
  amount: number;
  type: 'INCOME' | 'EXPENSE';
  category: string;
  date: string;
}

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private transactions: Transaction[] = [
    {
      description: 'Salário',
      amount: 3000,
      type: 'INCOME',
      category: 'Trabalho',
      date: '2026-01-30'
    },
    {
      description: 'Mercado',
      amount: 250,
      type: 'EXPENSE',
      category: 'Alimentação',
      date: '2026-01-29'
    }
  ];

  getAll(): Transaction[] {
    return this.transactions;
  }

  add(transaction: Transaction): void {
    this.transactions.unshift(transaction);
  }

  getSaldo(): number {
    return this.transactions.reduce((total, t) => {
      return t.type === 'INCOME'
        ? total + t.amount
        : total - t.amount;
    }, 0);
  }

  getEntradas(): number {
    return this.transactions
      .filter(t => t.type === 'INCOME')
      .reduce((sum, t) => sum + t.amount, 0);
  }

  getSaidas(): number {
    return this.transactions
      .filter(t => t.type === 'EXPENSE')
      .reduce((sum, t) => sum + t.amount, 0);
  }
}
