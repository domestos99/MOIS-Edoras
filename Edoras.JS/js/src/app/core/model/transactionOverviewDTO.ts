import {Category} from "@app/core/model/category";
import {Transaction} from "@app/core/api/model/transaction";

export class TransactionOverviewDTO {

  category: Category;
  transactions: Array<Transaction>;
  suma: number;

}
