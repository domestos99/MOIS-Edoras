import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

export class PaymentCategoryInsertDTO {


  constructor(private categoryId: String, private paymentId: String, private transactionPartyAccount: TransactionPartyAccount) {

  }


  // categoryId: String;
  // paymentId: String;
  // transactionPartyAccount: TransactionPartyAccount;

}
