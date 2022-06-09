import { User } from './../../../models/user';
import { SkykidService } from 'src/app/services/skykid.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profil-skykid',
  templateUrl: './profil-skykid.component.html',
  styleUrls: ['./profil-skykid.component.css'],
})
export class ProfilSkykidComponent implements OnInit {
  user: User = JSON.parse(sessionStorage.getItem('user')!);

  TotalBB: number = 0;
  TotalBR: number = 0;
  TotalC: number = 0;

  constructor(skykidService: SkykidService) {
    skykidService.getSkykidById(this.user.id!).subscribe((data) => {
      for (var i = 0; i < 3; i++) {
        if (data.devise[i].id == 100) {
          this.TotalBB = data.devise[i].quantite;
        }
        if (data.devise[i].id == 101) {
          this.TotalBR = data.devise[i].quantite;
        }
        if (data.devise[i].id == 102) {
          this.TotalC = data.devise[i].quantite;
        }
      }
    });
  }

  ngOnInit(): void {}
}
