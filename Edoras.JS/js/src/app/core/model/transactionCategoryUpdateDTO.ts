import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

export class TransactionCategoryUpdateDTO {


  constructor(private categoryId: string, private transactionId: string, private transactionPartyAccount: TransactionPartyAccount, private changeType : string) {

  }

}
