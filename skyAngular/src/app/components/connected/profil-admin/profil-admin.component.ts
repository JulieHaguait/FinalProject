import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-profil-admin',
  templateUrl: './profil-admin.component.html',
  styleUrls: ['./profil-admin.component.css'],
})
export class ProfilAdminComponent implements OnInit {
  user: User = new User();
  constructor(private router: Router) {}

  ngOnInit(): void {}
  get User(): User | null {
    if (sessionStorage.getItem('user')) {
      return JSON.parse(sessionStorage.getItem('user')!) as User;
    }
    return null;
  }
}
