/**
 * Swagger Banking
 * Simple Banking API used for MOIS on UHK. Api is derived from AIR bank API: https://www.airbank.cz/novinky-z-airbank/2017/open-api/open-api-banking.html#top
 *
 * OpenAPI spec version: 1.0.0
 * Contact: michal.gregor@uhk.cz
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { TransactionAdditionalInfoCard } from './transactionAdditionalInfoCard';
import { TransactionAdditionalInfoDomestic } from './transactionAdditionalInfoDomestic';
import { TransactionAdditionalInfoForeign } from './transactionAdditionalInfoForeign';
import { TransactionPartyAccount } from './transactionPartyAccount';
import { TransactionValue } from './transactionValue';


export interface Transaction { 
    /**
     * internal transaction identified
     */
    id: string;
    /**
     * account to that transaction belongs (to which it is accounted)
     */
    accountId: number;
    value: TransactionValue;
    partyAccount?: TransactionPartyAccount;
    /**
     * party description
     */
    partyDescription?: string;
    /**
     * transaction direction
     */
    direction: Transaction.DirectionEnum;
    /**
     * transaction type
     */
    transactionType: Transaction.TransactionTypeEnum;
    /**
     * transaction value date, e.g. the day transaction \"happened\"
     */
    valueDate: Date;
    /**
     * transaction booking date, e.g. the day transaction was bookkeeped
     */
    bookingDate: Date;
    /**
     * user transaction description
     */
    userDescription?: string;
    /**
     * message for payer. Empty for incoming transacionts.
     */
    payerMessage?: string;
    /**
     * message for payee (e.g. for client receiving transaction)
     */
    payeeMessage?: string;
    /**
     * id of category for transaction. More info about category can be retrieved using /openapi/banking/categories resource.
     */
    categoryId?: number;
    /**
     * fee related to transaction, in account's currency
     */
    transactionFee?: number;
    /**
     * set to true if transaction fee is canceled.
     */
    transactionFeeCanceled?: boolean;
    additionalInfoDomestic?: TransactionAdditionalInfoDomestic;
    additionalInfoForeign?: TransactionAdditionalInfoForeign;
    additionalInfoCard?: TransactionAdditionalInfoCard;
}
export namespace Transaction {
    export type DirectionEnum = 'INCOMING' | 'OUTGOING' | 'BOTH';
    export const DirectionEnum = {
        INCOMING: 'INCOMING' as DirectionEnum,
        OUTGOING: 'OUTGOING' as DirectionEnum,
        BOTH: 'BOTH' as DirectionEnum
    };
    export type TransactionTypeEnum = 'PAYMENT_HOME' | 'PAYMENT_ABROAD' | 'PAYMENT_PERSONAL' | 'PAYMENT_ACCOUNT' | 'STANDING_ORDER' | 'SAVING' | 'DIRECT_DEBIT' | 'DIRECT_DEBIT_SIPO' | 'CARD' | 'CASH' | 'FEE' | 'TAX' | 'INTEREST' | 'INSURANCE' | 'LOAN' | 'MORTGAGE' | 'SAZKA' | 'OTHER' | 'BLOCKING';
    export const TransactionTypeEnum = {
        PAYMENTHOME: 'PAYMENT_HOME' as TransactionTypeEnum,
        PAYMENTABROAD: 'PAYMENT_ABROAD' as TransactionTypeEnum,
        PAYMENTPERSONAL: 'PAYMENT_PERSONAL' as TransactionTypeEnum,
        PAYMENTACCOUNT: 'PAYMENT_ACCOUNT' as TransactionTypeEnum,
        STANDINGORDER: 'STANDING_ORDER' as TransactionTypeEnum,
        SAVING: 'SAVING' as TransactionTypeEnum,
        DIRECTDEBIT: 'DIRECT_DEBIT' as TransactionTypeEnum,
        DIRECTDEBITSIPO: 'DIRECT_DEBIT_SIPO' as TransactionTypeEnum,
        CARD: 'CARD' as TransactionTypeEnum,
        CASH: 'CASH' as TransactionTypeEnum,
        FEE: 'FEE' as TransactionTypeEnum,
        TAX: 'TAX' as TransactionTypeEnum,
        INTEREST: 'INTEREST' as TransactionTypeEnum,
        INSURANCE: 'INSURANCE' as TransactionTypeEnum,
        LOAN: 'LOAN' as TransactionTypeEnum,
        MORTGAGE: 'MORTGAGE' as TransactionTypeEnum,
        SAZKA: 'SAZKA' as TransactionTypeEnum,
        OTHER: 'OTHER' as TransactionTypeEnum,
        BLOCKING: 'BLOCKING' as TransactionTypeEnum
    };
}
