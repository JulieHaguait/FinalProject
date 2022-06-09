import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { SkykidService } from 'src/app/services/skykid.service';

@Component({
  selector: 'app-coeur',
  templateUrl: './coeur.component.html',
  styleUrls: ['./coeur.component.css'],
})
export class CoeurComponent implements OnInit {
  user: User = JSON.parse(sessionStorage.getItem('user')!);
  Coeur: number = 0;
  totalC: number = 0;

  constructor(private router: Router, private skykidService: SkykidService) {}

  ngOnInit(): void {}

  ajouter() {
    let obj = {
      id: this.user.id,
      login: this.user.login,
      type: this.user.type,
      devise: [
        {
          id: 102,
          quantite: this.Coeur,
        },
      ],
    };

    this.skykidService.updateSkykid(obj).subscribe(() => {
      this.router.navigateByUrl('/profil-skykid');
    });
  }
}
