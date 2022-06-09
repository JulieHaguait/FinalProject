import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bb',
  templateUrl: './bb.component.html',
  styleUrls: ['./bb.component.css'],
})
export class BbComponent implements OnInit {
  BougiesB: number = 0;
  totalBB: number = 0;
  constructor(private router: Router) {}

  ngOnInit(): void {}
  ajouter() {
    console.log(this.BougiesB);
  }
}
