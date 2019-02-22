package cz.uhk.mois.edoras.domain;

import java.io.Serializable;

public class Category implements Serializable, IDbEntity
{
    private String cateID;
    private String  cateName;

    public Category()
    {
    }

    public Category(String cateID, String cateName)
    {
        this.cateID = cateID;
        this.cateName = cateName;
    }

    public String getCateID()
    {
        return cateID;
    }

    public void setCateID(String cateID)
    {
        this.cateID = cateID;
    }

    public String getCateName()
    {
        return cateName;
    }

    public void setCateName(String cateName)
    {
        this.cateName = cateName;
    }

    @Override
    public String getId()
    {
        return cateID;
    }
}
