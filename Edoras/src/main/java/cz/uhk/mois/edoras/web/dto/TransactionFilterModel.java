package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionFilterModel implements Serializable
{
    private Date dtFrom;
    private Date dtTo;
    private String cateId;

    public Date getDtFrom()
    {
        return dtFrom;
    }

    public void setDtFrom(Date dtFrom)
    {
        this.dtFrom = dtFrom;
    }

    public Date getDtTo()
    {
        return dtTo;
    }

    public void setDtTo(Date dtTo)
    {
        this.dtTo = dtTo;
    }

    public String getCateId()
    {
        return cateId;
    }

    public void setCateId(String cateId)
    {
        this.cateId = cateId;
    }
}
