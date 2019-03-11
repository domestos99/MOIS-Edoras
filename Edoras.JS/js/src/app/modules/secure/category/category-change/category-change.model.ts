import {Transaction} from "@app/core/api/model/transaction";

export class CategoryChangeModel {

  newCategory: string;
  changeType: string;
  direction: Transaction.DirectionEnum;

}
