export class User {
  public constructor(private _login?: string, private _type?: string) {}

  get login(): string | undefined {
    return this._login;
  }

  set login(value: string | undefined) {
    this._login = value;
  }

  get type(): string | undefined {
    return this._type;
  }

  set type(value: string | undefined) {
    this._type = value;
  }
}
