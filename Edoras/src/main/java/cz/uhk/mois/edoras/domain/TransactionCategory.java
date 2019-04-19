package cz.uhk.mois.edoras.domain;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"transactionId"})
})
public class TransactionCategory implements Serializable
{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;


    @ManyToOne
    private Category category;
    private String transactionId;
    private String transactionAccount;
    private Transaction.DirectionEnum direction;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getTransactionAccount()
    {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount)
    {
        this.transactionAccount = transactionAccount;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public Transaction.DirectionEnum getDirection()
    {
        return direction;
    }

    public void setDirection(Transaction.DirectionEnum direction)
    {
        this.direction = direction;
    }
}
