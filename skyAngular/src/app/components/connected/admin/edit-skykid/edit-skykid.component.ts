import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SkykidService } from 'src/app/services/skykid.service';
import { User } from 'src/app/models/user';
@Component({
  selector: 'app-edit-skykid',
  templateUrl: './edit-skykid.component.html',
  styleUrls: ['./edit-skykid.component.css'],
})
export class EditSkykidComponent implements OnInit {
  user: User;
  constructor(
    private activatedRoute: ActivatedRoute,
    private skykidService: SkykidService,
    private router: Router
  ) {
    this.user = new User();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.skykidService.getById(params['id']).subscribe((data) => {
          this.user = data;
        });
      }
    });
  }
  save() {
    console.log('update');
    this.skykidService.update(this.user).subscribe(() => {
      this.router.navigateByUrl('/profil-admin/list-skykidS');
    });
  }
}
