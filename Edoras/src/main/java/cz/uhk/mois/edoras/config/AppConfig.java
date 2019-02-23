package cz.uhk.mois.edoras.config;

public class AppConfig
{
    // TODO load from application.properties

    public static final String ExternalAPIUrlBase = "http://localhost:5000/";
    public static final String ExternalAPIShoppingList = ExternalAPIUrlBase + "shoppingList";
    public static final String AccountID = "9876";
    public static final int ApiConnectTimeout = 5000;
}
