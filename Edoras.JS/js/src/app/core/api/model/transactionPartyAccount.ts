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


/**
 * party account number
 */
export interface TransactionPartyAccount { 
    /**
     * account number prefix
     */
    prefix?: string;
    /**
     * account number. For domestic accounts, this will be specified in national format.
     */
    accountNumber: string;
    /**
     * for domestic accounts, bank code in national format; for foreign accounts, BIC code.
     */
    bankCode: string;
}
