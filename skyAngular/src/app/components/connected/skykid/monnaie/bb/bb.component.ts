import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { SkykidService } from 'src/app/services/skykid.service';

@Component({
  selector: 'app-bb',
  templateUrl: './bb.component.html',
  styleUrls: ['./bb.component.css'],
})
export class BbComponent implements OnInit {
  BougiesB: number = 0;
  totalBB: number = 0;
  user: User = JSON.parse(sessionStorage.getItem('user')!);

  constructor(private router: Router, private skykidService: SkykidService) {
    skykidService.getSkykidById(this.user.id!).subscribe((data) => {
      for (var i = 0; i < 3; i++) {
        if (data.devise[i].id == 100) {
          this.totalBB = data.devise[i].quantite;
        }
      }
    });
  }

  ngOnInit(): void {}
  ajouter() {
    let obj = {
      id: this.user.id,
      login: this.user.login,
      type: this.user.type,
      devise: [
        {
          id: 100,
          quantite: this.BougiesB,
        },
      ],
    };

    this.skykidService.updateSkykid(obj).subscribe(() => {
      this.router.navigateByUrl('/profil-skykid');
    });
  }
}
