import { NodeRefService } from './../../../../services/node-ref.service';
import { NodeRef } from './../../../../models/node-ref';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestion-boutique',
  templateUrl: './gestion-boutique.component.html',
  styleUrls: ['./gestion-boutique.component.css'],
})
export class GestionBoutiqueComponent implements OnInit {
  nameSelect: string = '';
  nodesRef: Observable<NodeRef[]>;

  constructor(private nodeRefService: NodeRefService) {
    this.nodesRef = this.nodeRefService.getAll();
  }

  ngOnInit(): void {}
}
