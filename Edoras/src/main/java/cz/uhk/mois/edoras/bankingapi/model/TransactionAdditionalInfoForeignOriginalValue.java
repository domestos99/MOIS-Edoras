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

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * amount &amp; currency in which transaction was originated
 */
@ApiModel(description = "amount & currency in which transaction was originated")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T15:21:33.179Z")
public class TransactionAdditionalInfoForeignOriginalValue {
  @SerializedName("amount")
  private BigDecimal amount = null;

  @SerializedName("currency")
  private String currency = null;

  public TransactionAdditionalInfoForeignOriginalValue amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * amount of money
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "amount of money")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public TransactionAdditionalInfoForeignOriginalValue currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * currency of money
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "currency of money")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionAdditionalInfoForeignOriginalValue transactionAdditionalInfoForeignOriginalValue = (TransactionAdditionalInfoForeignOriginalValue) o;
    return Objects.equals(this.amount, transactionAdditionalInfoForeignOriginalValue.amount) &&
        Objects.equals(this.currency, transactionAdditionalInfoForeignOriginalValue.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionAdditionalInfoForeignOriginalValue {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

