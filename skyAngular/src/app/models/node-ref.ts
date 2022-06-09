import { Item } from './item';

export class NodeRef {
  public constructor(
    private _id?: number,
    private _realm?: string,
    private _spiritName?: string,
    private _item?: Item,
    private _nodeParent?: NodeRef
  ) {}

  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  get realm(): string | undefined {
    return this._realm;
  }

  set realm(value: string | undefined) {
    this._realm = value;
  }

  get spiritName(): string | undefined {
    return this._spiritName;
  }

  set spiritName(value: string | undefined) {
    this._spiritName = value;
  }

  get item(): Item | undefined {
    return this._item;
  }

  set item(value: Item | undefined) {
    this._item = value;
  }

  get nodeParent(): NodeRef | undefined {
    return this._nodeParent;
  }

  set nodeParent(value: NodeRef | undefined) {
    this._nodeParent = value;
  }
}
