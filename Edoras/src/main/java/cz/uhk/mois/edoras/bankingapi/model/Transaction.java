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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import cz.uhk.mois.edoras.domain.Category;
import io.swagger.annotations.ApiModelProperty;

/**
 * Transaction
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T15:21:33.179Z")
@Entity
public class Transaction
{
    @SerializedName("_id")
    @Id
    private String id = null;

    @ManyToOne
    private Category category;

    @SerializedName("accountId")
    private BigDecimal accountId = null;

    @SerializedName("value")
    @Embedded
    private TransactionValue value = null;

    @SerializedName("partyAccount")
    @Embedded
    private TransactionPartyAccount partyAccount = null;

    @SerializedName("partyDescription")
    private String partyDescription = null;

    /**
     * transaction direction
     */
    @JsonAdapter(DirectionEnum.Adapter.class)
    public enum DirectionEnum
    {
        INCOMING("INCOMING"),

        OUTGOING("OUTGOING"),

        BOTH("BOTH");

        private String value;

        DirectionEnum(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

        public static DirectionEnum fromValue(String text)
        {
            for (DirectionEnum b : DirectionEnum.values())
            {
                if (String.valueOf(b.value).equals(text))
                {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<DirectionEnum>
        {
            @Override
            public void write(final JsonWriter jsonWriter, final DirectionEnum enumeration) throws IOException
            {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DirectionEnum read(final JsonReader jsonReader) throws IOException
            {
                String value = jsonReader.nextString();
                return DirectionEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("direction")
    private DirectionEnum direction = null;

    /**
     * transaction type
     */
    @JsonAdapter(TransactionTypeEnum.Adapter.class)
    public enum TransactionTypeEnum
    {
        PAYMENT_HOME("PAYMENT_HOME"),

        PAYMENT_ABROAD("PAYMENT_ABROAD"),

        PAYMENT_PERSONAL("PAYMENT_PERSONAL"),

        PAYMENT_ACCOUNT("PAYMENT_ACCOUNT"),

        STANDING_ORDER("STANDING_ORDER"),

        SAVING("SAVING"),

        DIRECT_DEBIT("DIRECT_DEBIT"),

        DIRECT_DEBIT_SIPO("DIRECT_DEBIT_SIPO"),

        CARD("CARD"),

        CASH("CASH"),

        FEE("FEE"),

        TAX("TAX"),

        INTEREST("INTEREST"),

        INSURANCE("INSURANCE"),

        LOAN("LOAN"),

        MORTGAGE("MORTGAGE"),

        SAZKA("SAZKA"),

        OTHER("OTHER"),

        BLOCKING("BLOCKING");

        private String value;

        TransactionTypeEnum(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

        public static TransactionTypeEnum fromValue(String text)
        {
            for (TransactionTypeEnum b : TransactionTypeEnum.values())
            {
                if (String.valueOf(b.value).equals(text))
                {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TransactionTypeEnum>
        {
            @Override
            public void write(final JsonWriter jsonWriter, final TransactionTypeEnum enumeration) throws IOException
            {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TransactionTypeEnum read(final JsonReader jsonReader) throws IOException
            {
                String value = jsonReader.nextString();
                return TransactionTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("transactionType")
    private TransactionTypeEnum transactionType = null;

    @SerializedName("valueDate")
    private Date valueDate = null;

    @SerializedName("bookingDate")
    private Date bookingDate = null;

    @SerializedName("userDescription")
    private String userDescription = null;

    @SerializedName("payerMessage")
    private String payerMessage = null;

    @SerializedName("payeeMessage")
    private String payeeMessage = null;

    @SerializedName("transactionFee")
    private BigDecimal transactionFee = null;

    @SerializedName("transactionFeeCanceled")
    private Boolean transactionFeeCanceled = null;

    @SerializedName("additionalInfoDomestic")
    @Embedded
    private TransactionAdditionalInfoDomestic additionalInfoDomestic = null;

    @SerializedName("additionalInfoForeign")
    @Embedded
    private TransactionAdditionalInfoForeign additionalInfoForeign = null;

    @SerializedName("additionalInfoCard")
    @Embedded
    private TransactionAdditionalInfoCard additionalInfoCard = null;

    public Transaction id(String id)
    {
        this.id = id;
        return this;
    }

    /**
     * internal transaction identified
     *
     * @return id
     **/
    @ApiModelProperty(required = true, value = "internal transaction identified")
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Transaction accountId(BigDecimal accountId)
    {
        this.accountId = accountId;
        return this;
    }

    /**
     * account to that transaction belongs (to which it is accounted)
     *
     * @return accountId
     **/
    @ApiModelProperty(required = true, value = "account to that transaction belongs (to which it is accounted)")
    public BigDecimal getAccountId()
    {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId)
    {
        this.accountId = accountId;
    }

    public Transaction value(TransactionValue value)
    {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @ApiModelProperty(required = true, value = "")
    public TransactionValue getValue()
    {
        return value;
    }

    public void setValue(TransactionValue value)
    {
        this.value = value;
    }

    public Transaction partyAccount(TransactionPartyAccount partyAccount)
    {
        this.partyAccount = partyAccount;
        return this;
    }

    /**
     * Get partyAccount
     *
     * @return partyAccount
     **/
    @ApiModelProperty(value = "")
    public TransactionPartyAccount getPartyAccount()
    {
        return partyAccount;
    }

    public void setPartyAccount(TransactionPartyAccount partyAccount)
    {
        this.partyAccount = partyAccount;
    }

    public Transaction partyDescription(String partyDescription)
    {
        this.partyDescription = partyDescription;
        return this;
    }

    /**
     * party description
     *
     * @return partyDescription
     **/
    @ApiModelProperty(value = "party description")
    public String getPartyDescription()
    {
        return partyDescription;
    }

    public void setPartyDescription(String partyDescription)
    {
        this.partyDescription = partyDescription;
    }

    public Transaction direction(DirectionEnum direction)
    {
        this.direction = direction;
        return this;
    }

    /**
     * transaction direction
     *
     * @return direction
     **/
    @ApiModelProperty(required = true, value = "transaction direction")
    public DirectionEnum getDirection()
    {
        return direction;
    }

    public void setDirection(DirectionEnum direction)
    {
        this.direction = direction;
    }

    public Transaction transactionType(TransactionTypeEnum transactionType)
    {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * transaction type
     *
     * @return transactionType
     **/
    @ApiModelProperty(required = true, value = "transaction type")
    public TransactionTypeEnum getTransactionType()
    {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType)
    {
        this.transactionType = transactionType;
    }

    public Transaction valueDate(Date valueDate)
    {
        this.valueDate = valueDate;
        return this;
    }

    /**
     * transaction value date, e.g. the day transaction \&quot;happened\&quot;
     *
     * @return valueDate
     **/
    @ApiModelProperty(required = true, value = "transaction value date, e.g. the day transaction \"happened\"")
    public Date getValueDate()
    {
        return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
        this.valueDate = valueDate;
    }

    public Transaction bookingDate(Date bookingDate)
    {
        this.bookingDate = bookingDate;
        return this;
    }

    /**
     * transaction booking date, e.g. the day transaction was bookkeeped
     *
     * @return bookingDate
     **/
    @ApiModelProperty(required = true, value = "transaction booking date, e.g. the day transaction was bookkeeped")
    public Date getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate)
    {
        this.bookingDate = bookingDate;
    }

    public Transaction userDescription(String userDescription)
    {
        this.userDescription = userDescription;
        return this;
    }

    /**
     * user transaction description
     *
     * @return userDescription
     **/
    @ApiModelProperty(value = "user transaction description")
    public String getUserDescription()
    {
        return userDescription;
    }

    public void setUserDescription(String userDescription)
    {
        this.userDescription = userDescription;
    }

    public Transaction payerMessage(String payerMessage)
    {
        this.payerMessage = payerMessage;
        return this;
    }

    /**
     * message for payer. Empty for incoming transacionts.
     *
     * @return payerMessage
     **/
    @ApiModelProperty(value = "message for payer. Empty for incoming transacionts.")
    public String getPayerMessage()
    {
        return payerMessage;
    }

    public void setPayerMessage(String payerMessage)
    {
        this.payerMessage = payerMessage;
    }

    public Transaction payeeMessage(String payeeMessage)
    {
        this.payeeMessage = payeeMessage;
        return this;
    }

    /**
     * message for payee (e.g. for client receiving transaction)
     *
     * @return payeeMessage
     **/
    @ApiModelProperty(value = "message for payee (e.g. for client receiving transaction)")
    public String getPayeeMessage()
    {
        return payeeMessage;
    }

    public void setPayeeMessage(String payeeMessage)
    {
        this.payeeMessage = payeeMessage;
    }

    public Transaction transactionFee(BigDecimal transactionFee)
    {
        this.transactionFee = transactionFee;
        return this;
    }

    /**
     * fee related to transaction, in account&#39;s currency
     *
     * @return transactionFee
     **/
    @ApiModelProperty(value = "fee related to transaction, in account's currency")
    public BigDecimal getTransactionFee()
    {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee)
    {
        this.transactionFee = transactionFee;
    }

    public Transaction transactionFeeCanceled(Boolean transactionFeeCanceled)
    {
        this.transactionFeeCanceled = transactionFeeCanceled;
        return this;
    }

    /**
     * set to true if transaction fee is canceled.
     *
     * @return transactionFeeCanceled
     **/
    @ApiModelProperty(value = "set to true if transaction fee is canceled.")
    public Boolean isTransactionFeeCanceled()
    {
        return transactionFeeCanceled;
    }

    public void setTransactionFeeCanceled(Boolean transactionFeeCanceled)
    {
        this.transactionFeeCanceled = transactionFeeCanceled;
    }

    public Transaction additionalInfoDomestic(TransactionAdditionalInfoDomestic additionalInfoDomestic)
    {
        this.additionalInfoDomestic = additionalInfoDomestic;
        return this;
    }

    /**
     * Get additionalInfoDomestic
     *
     * @return additionalInfoDomestic
     **/
    @ApiModelProperty(value = "")
    public TransactionAdditionalInfoDomestic getAdditionalInfoDomestic()
    {
        return additionalInfoDomestic;
    }

    public void setAdditionalInfoDomestic(TransactionAdditionalInfoDomestic additionalInfoDomestic)
    {
        this.additionalInfoDomestic = additionalInfoDomestic;
    }

    public Transaction additionalInfoForeign(TransactionAdditionalInfoForeign additionalInfoForeign)
    {
        this.additionalInfoForeign = additionalInfoForeign;
        return this;
    }

    /**
     * Get additionalInfoForeign
     *
     * @return additionalInfoForeign
     **/
    @ApiModelProperty(value = "")
    public TransactionAdditionalInfoForeign getAdditionalInfoForeign()
    {
        return additionalInfoForeign;
    }

    public void setAdditionalInfoForeign(TransactionAdditionalInfoForeign additionalInfoForeign)
    {
        this.additionalInfoForeign = additionalInfoForeign;
    }

    public Transaction additionalInfoCard(TransactionAdditionalInfoCard additionalInfoCard)
    {
        this.additionalInfoCard = additionalInfoCard;
        return this;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Boolean getTransactionFeeCanceled()
    {
        return transactionFeeCanceled;
    }

    /**
     * Get additionalInfoCard
     *
     * @return additionalInfoCard
     **/
    @ApiModelProperty(value = "")
    public TransactionAdditionalInfoCard getAdditionalInfoCard()
    {
        return additionalInfoCard;
    }

    public void setAdditionalInfoCard(TransactionAdditionalInfoCard additionalInfoCard)
    {
        this.additionalInfoCard = additionalInfoCard;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(this.id, transaction.id) &&
                Objects.equals(this.accountId, transaction.accountId) &&
                Objects.equals(this.value, transaction.value) &&
                Objects.equals(this.partyAccount, transaction.partyAccount) &&
                Objects.equals(this.partyDescription, transaction.partyDescription) &&
                Objects.equals(this.direction, transaction.direction) &&
                Objects.equals(this.transactionType, transaction.transactionType) &&
                Objects.equals(this.valueDate, transaction.valueDate) &&
                Objects.equals(this.bookingDate, transaction.bookingDate) &&
                Objects.equals(this.userDescription, transaction.userDescription) &&
                Objects.equals(this.payerMessage, transaction.payerMessage) &&
                Objects.equals(this.payeeMessage, transaction.payeeMessage) &&
                Objects.equals(this.transactionFee, transaction.transactionFee) &&
                Objects.equals(this.transactionFeeCanceled, transaction.transactionFeeCanceled) &&
                Objects.equals(this.additionalInfoDomestic, transaction.additionalInfoDomestic) &&
                Objects.equals(this.additionalInfoForeign, transaction.additionalInfoForeign) &&
                Objects.equals(this.additionalInfoCard, transaction.additionalInfoCard);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, accountId, value, partyAccount, partyDescription, direction, transactionType,
                valueDate, bookingDate, userDescription, payerMessage, payeeMessage, transactionFee, transactionFeeCanceled,
                additionalInfoDomestic, additionalInfoForeign, additionalInfoCard);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transaction {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    partyAccount: ").append(toIndentedString(partyAccount)).append("\n");
        sb.append("    partyDescription: ").append(toIndentedString(partyDescription)).append("\n");
        sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
        sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
        sb.append("    valueDate: ").append(toIndentedString(valueDate)).append("\n");
        sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
        sb.append("    userDescription: ").append(toIndentedString(userDescription)).append("\n");
        sb.append("    payerMessage: ").append(toIndentedString(payerMessage)).append("\n");
        sb.append("    payeeMessage: ").append(toIndentedString(payeeMessage)).append("\n");
        sb.append("    transactionFee: ").append(toIndentedString(transactionFee)).append("\n");
        sb.append("    transactionFeeCanceled: ").append(toIndentedString(transactionFeeCanceled)).append("\n");
        sb.append("    additionalInfoDomestic: ").append(toIndentedString(additionalInfoDomestic)).append("\n");
        sb.append("    additionalInfoForeign: ").append(toIndentedString(additionalInfoForeign)).append("\n");
        sb.append("    additionalInfoCard: ").append(toIndentedString(additionalInfoCard)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

