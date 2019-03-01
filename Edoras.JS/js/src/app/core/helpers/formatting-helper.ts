import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {TransactionValue} from "@app/core/api/model/transactionValue";
import {TransactionAdditionalInfoForeignOriginalValue} from "@app/core/api/model/transactionAdditionalInfoForeignOriginalValue";

export class FormattingHelper {

  public static getAccountFormatted(account: TransactionPartyAccount): string {

    if (!account)
      return "";

    if (account.prefix)
      return account.prefix + "-" + account.accountNumber + "/" + account.bankCode;
    else
      return account.accountNumber + "/" + account.bankCode;
  }

  static getMoneyFormattedPay(paymentValue: PaymentValue) {
    if (!paymentValue)
      return "";

    return paymentValue.amount + " " + paymentValue.currency;
  }

  static getMoneyFormattedTrans(transactionValue: TransactionValue) {
    if (!transactionValue)
      return "";

    return transactionValue.amount + " " + transactionValue.currency;
  }


  static getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue: TransactionAdditionalInfoForeignOriginalValue): string {

    if (!originalValue)
      return "";

    return originalValue.amount + " " + originalValue.currency;
  }
}
