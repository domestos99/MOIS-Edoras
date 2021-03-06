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
import {PaymentAdditionalInfo} from './paymentAdditionalInfo';
import {PaymentRecuringPayment} from './paymentRecuringPayment';
import {PaymentValue} from './paymentValue';
import {TransactionPartyAccount} from './transactionPartyAccount';
import {Category} from "@app/core/model";


export interface Payment {

  value: PaymentValue;
  partyAccount: TransactionPartyAccount;

  category: Category;
  /**
   * payment order due date
   */
  dueDate: Date;
  recuringPayment?: PaymentRecuringPayment;
  /**
   * message for payee
   */
  payeeMessage?: string;
  /**
   * message for payer
   */
  payerMessage?: string;
  /**
   * id of category for payment order. More info about category can be retrieved using /openapi/banking/categories resource.
   */
  categoryId?: number;
  additionalInfo?: PaymentAdditionalInfo;
  /**
   * internal domestic payment order identifier
   */
  id: string;
  /**
   * account to that payment belongs (to which it is accounted)
   */
  accountId: number;
  /**
   * editable flag; true if user can modify payment order
   */
  editableByUser: boolean;
  /**
   * payment order realization status
   */
  realizationStatus: Payment.RealizationStatusEnum;
}

export namespace Payment {
  export type RealizationStatusEnum =
    'RTS_EDITED'
    | 'RTS_NOT_REALISED'
    | 'RTS_NOT_FULLY_REALISED'
    | 'RTS_REALISED'
    | 'RTS_SUSPENDED'
    | 'RTS_ENDED'
    | 'RTS_WAIT_FOR_AUTHORISATION'
    | 'RTS_FAULTY_PARAMS'
    | 'RTS_READY_TO_SEND'
    | 'RTS_SENT'
    | 'RTS_REFUSED_BY_COUNTERPARTY'
    | 'RTS_REFUSED_ERROR'
    | 'RTS_INPROC'
    | 'RTS_WAITS_FOR_APPROVAL'
    | 'RTS_PARTLYSIGNED'
    | 'RTS_SIGNED'
    | 'RTS_PARTLYEDITED'
    | 'RTS_CANCELLED'
    | 'RTS_FOR_EXT_PROCESSING'
    | 'RTS_WAIT_FOR_CNDPRECEDENT';
  export const RealizationStatusEnum = {
    EDITED: 'RTS_EDITED' as RealizationStatusEnum,
    NOTREALISED: 'RTS_NOT_REALISED' as RealizationStatusEnum,
    NOTFULLYREALISED: 'RTS_NOT_FULLY_REALISED' as RealizationStatusEnum,
    REALISED: 'RTS_REALISED' as RealizationStatusEnum,
    SUSPENDED: 'RTS_SUSPENDED' as RealizationStatusEnum,
    ENDED: 'RTS_ENDED' as RealizationStatusEnum,
    WAITFORAUTHORISATION: 'RTS_WAIT_FOR_AUTHORISATION' as RealizationStatusEnum,
    FAULTYPARAMS: 'RTS_FAULTY_PARAMS' as RealizationStatusEnum,
    READYTOSEND: 'RTS_READY_TO_SEND' as RealizationStatusEnum,
    SENT: 'RTS_SENT' as RealizationStatusEnum,
    REFUSEDBYCOUNTERPARTY: 'RTS_REFUSED_BY_COUNTERPARTY' as RealizationStatusEnum,
    REFUSEDERROR: 'RTS_REFUSED_ERROR' as RealizationStatusEnum,
    INPROC: 'RTS_INPROC' as RealizationStatusEnum,
    WAITSFORAPPROVAL: 'RTS_WAITS_FOR_APPROVAL' as RealizationStatusEnum,
    PARTLYSIGNED: 'RTS_PARTLYSIGNED' as RealizationStatusEnum,
    SIGNED: 'RTS_SIGNED' as RealizationStatusEnum,
    PARTLYEDITED: 'RTS_PARTLYEDITED' as RealizationStatusEnum,
    CANCELLED: 'RTS_CANCELLED' as RealizationStatusEnum,
    FOREXTPROCESSING: 'RTS_FOR_EXT_PROCESSING' as RealizationStatusEnum,
    WAITFORCNDPRECEDENT: 'RTS_WAIT_FOR_CNDPRECEDENT' as RealizationStatusEnum
  };
}
