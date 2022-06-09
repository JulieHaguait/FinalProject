import { NodeRef } from './node-ref';
import { Monnaie } from './monnaie';

export class Item {
  public constructor(
    private _id?: number,
    private _libelle?: string,
    private _prix?: number,
    private _nodeRef?: NodeRef,
    private _monnaie?: Monnaie
  ) {}

  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  get libelle(): string | undefined {
    return this._libelle;
  }

  set libelle(value: string | undefined) {
    this._libelle = value;
  }

  get prix(): number | undefined {
    return this._prix;
  }

  set prix(value: number | undefined) {
    this._prix = value;
  }

  get nodeRef(): NodeRef | undefined {
    return this._nodeRef;
  }

  set nodeRef(value: NodeRef | undefined) {
    this._nodeRef = value;
  }

  get monnaie(): Monnaie | undefined {
    return this._monnaie;
  }

  set monnaie(value: Monnaie | undefined) {
    this._monnaie = value;
  }
}
