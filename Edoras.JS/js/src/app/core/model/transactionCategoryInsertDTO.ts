import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

export class TransactionCategoryInsertDTO {


  constructor(private categoryId: string, private transactionId: string, private transactionPartyAccount: TransactionPartyAccount) {

  }

}
