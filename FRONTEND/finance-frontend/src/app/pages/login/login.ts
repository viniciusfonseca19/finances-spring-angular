import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent {

  email: string = '';
  password: string = '';
  error: string = '';

  constructor(private router: Router) {}

  submit() {
    this.error = '';

   
    if (this.email && this.password) {
      this.router.navigate(['/dashboard']); 
    } else {
      this.error = 'Email ou senha inválidos';
    }
  }
}
