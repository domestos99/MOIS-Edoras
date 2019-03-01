/*
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


package cz.uhk.mois.edoras.bankingapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * card payemnts additional info (card number, mcc and merchant name)
 */
@ApiModel(description = "card payemnts additional info (card number, mcc and merchant name)")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T15:21:33.179Z")
public class TransactionAdditionalInfoCard {
  @SerializedName("mcc")
  private String mcc = null;

  @SerializedName("merchantName")
  private String merchantName = null;

  @SerializedName("cardNumber")
  private String cardNumber = null;

  public TransactionAdditionalInfoCard mcc(String mcc) {
    this.mcc = mcc;
    return this;
  }

   /**
   * Merchant Category code
   * @return mcc
  **/
  @ApiModelProperty(value = "Merchant Category code")
  public String getMcc() {
    return mcc;
  }

  public void setMcc(String mcc) {
    this.mcc = mcc;
  }

  public TransactionAdditionalInfoCard merchantName(String merchantName) {
    this.merchantName = merchantName;
    return this;
  }

   /**
   * Get merchantName
   * @return merchantName
  **/
  @ApiModelProperty(value = "")
  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public TransactionAdditionalInfoCard cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

   /**
   * masked card number used for transaction
   * @return cardNumber
  **/
  @ApiModelProperty(required = true, value = "masked card number used for transaction")
  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionAdditionalInfoCard transactionAdditionalInfoCard = (TransactionAdditionalInfoCard) o;
    return Objects.equals(this.mcc, transactionAdditionalInfoCard.mcc) &&
        Objects.equals(this.merchantName, transactionAdditionalInfoCard.merchantName) &&
        Objects.equals(this.cardNumber, transactionAdditionalInfoCard.cardNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mcc, merchantName, cardNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionAdditionalInfoCard {\n");
    
    sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
    sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

