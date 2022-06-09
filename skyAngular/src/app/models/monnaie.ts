export class Monnaie {
  public constructor(private _id?: number, private _libelle?: string) {}

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
}
