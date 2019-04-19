package cz.uhk.mois.edoras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig
{
    public static String AccountID;

    @Value("${appconfig.accountid}")
    public void setAccountID(String value)
    {
        AccountID = value;
    }

    public static String BankingApiUrl;

    @Value("${appconfig.bankingapiurl}")
    public void setBankingApiUrl(String value)
    {
        BankingApiUrl = value;
    }

    public static int ApiConnectTimeout;

    @Value("${appconfig.apiconnectiontimeout}")
    public void setApiConnectTimeout(int value)
    {
        ApiConnectTimeout = value;
    }



}
