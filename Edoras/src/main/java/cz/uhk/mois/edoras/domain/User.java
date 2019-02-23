package cz.uhk.mois.edoras.domain;

import java.io.Serializable;

public class User implements Serializable
{
    private String token;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
}
