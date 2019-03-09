package cz.uhk.mois.edoras.logger;

public class LoggerFacade
{
    public static void log(String message)
    {
        System.out.println(message);
    }

    public static void log(Exception ex)
    {
        ex.printStackTrace();
    }
}