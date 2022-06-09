import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  get logged() {
    return sessionStorage.getItem('token');
  }

  get user(): User | null {
    if (sessionStorage.getItem('user')) {
      return JSON.parse(sessionStorage.getItem('user')!) as User;
    }
    return null;
  }

  get isSkykid(): boolean | null {
    let u = JSON.parse(sessionStorage.getItem('user')!) as User;
    if (u.type == 'skykid') {
      return true as boolean;
    } else {
      return false as boolean;
    }
  }

  get isAdmin() {
    let u = JSON.parse(sessionStorage.getItem('user')!) as User;
    if (u.type == 'admin') {
      return true as boolean;
    } else {
      return false as boolean;
    }
  }

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }
}
