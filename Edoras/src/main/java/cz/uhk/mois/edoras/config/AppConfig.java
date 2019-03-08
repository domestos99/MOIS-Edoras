package cz.uhk.mois.edoras.config;

public class AppConfig
{
    // TODO load from application.properties

    public static final String BankingApiUrl = "https://mois-banking.herokuapp.com/v1/";
    public static final String AccountID = "9876";
    public static final int ApiConnectTimeout = 5000;
    //public static final int TIME_CACHE_SYNC = 60000;
    public static final int TIME_CACHE_SYNC = 600000;
}
