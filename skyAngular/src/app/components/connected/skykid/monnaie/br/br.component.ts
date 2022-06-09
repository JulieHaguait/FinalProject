import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { SkykidService } from 'src/app/services/skykid.service';

@Component({
  selector: 'app-br',
  templateUrl: './br.component.html',
  styleUrls: ['./br.component.css'],
})
export class BrComponent implements OnInit {
  user: User = JSON.parse(sessionStorage.getItem('user')!);
  BougiesR: number = 0;
  totalBR: number = 0;

  constructor(private router: Router, private skykidService: SkykidService) {}

  ngOnInit(): void {}

  ajouter() {
    let obj = {
      id: this.user.id,
      login: this.user.login,
      type: this.user.type,
      devise: [
        {
          id: 101,
          quantite: this.BougiesR,
        },
      ],
    };

    this.skykidService.updateSkykid(obj).subscribe(() => {
      this.router.navigateByUrl('/profil-skykid');
    });
  }
}
