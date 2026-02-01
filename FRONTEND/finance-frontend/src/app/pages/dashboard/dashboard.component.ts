import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { TransactionService } from '../../core/services/transaction-service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  saldoTotal = 0;
  entradas = 0;
  saidas = 0;

  constructor(
    private transactionService: TransactionService,
    private router: Router
  ) {
    this.atualizarDados();
  }

  atualizarDados(): void {
    this.saldoTotal = this.transactionService.getSaldo();
    this.entradas = this.transactionService.getEntradas();
    this.saidas = this.transactionService.getSaidas();
  }

  irParaTransacoes(): void {
    this.router.navigate(['/transactions']);
  }

  logout(): void {
    this.router.navigate(['/login']);
  }
}