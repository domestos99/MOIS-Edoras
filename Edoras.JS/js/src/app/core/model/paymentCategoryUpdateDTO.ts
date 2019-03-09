import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

export class PaymentCategoryUpdateDTO {

  constructor(private categoryId: String, private paymentId: String, private transactionPartyAccount: TransactionPartyAccount, private changeType : string) {

  }

}
