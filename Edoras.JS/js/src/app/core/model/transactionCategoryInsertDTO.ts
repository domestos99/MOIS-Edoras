import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

export interface TransactionCategoryInsertDTO {

  categoryId: String;
  transactionId: String;
  transactionPartyAccount: TransactionPartyAccount;

}
