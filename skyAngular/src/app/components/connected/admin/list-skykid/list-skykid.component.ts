import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { SkykidService } from 'src/app/services/skykid.service';

@Component({
  selector: 'app-list-skykid',
  templateUrl: './list-skykid.component.html',
  styleUrls: ['./list-skykid.component.css'],
})
export class ListSkykidComponent implements OnInit {
  users: Observable<User[]>;
  constructor(private skykidService: SkykidService) {
    this.users = this.skykidService.getAllSkykid();
  }

  ngOnInit(): void {}

  delete(id: number) {
    this.skykidService.delete(id).subscribe(() => {
      this.users = this.skykidService.getAllSkykid();
    });
  }
}
