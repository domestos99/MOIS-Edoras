package cz.uhk.mois.edoras.bankingapi;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.config.AppConfig;
import cz.uhk.mois.edoras.utils.JsonUtilsSafe;
import cz.uhk.mois.edoras.utils.StringUtil;
import cz.uhk.mois.edoras.utils.http.HttpGetTask;

public class BankingApiFacade
{
    private static String getApiUrl(String apiEndpoint, GregorianCalendar dtFrom, GregorianCalendar dtTo)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        StringBuilder sbUrl = new StringBuilder();

        sbUrl.append(AppConfig.BankingApiUrl);
        sbUrl.append(apiEndpoint);
        sbUrl.append("/findByDate");
        sbUrl.append("?dateFrom=");
        format.setCalendar(dtFrom);
        sbUrl.append(format.format(dtFrom.getTime()));
        sbUrl.append("&dateTo=");
        format.setCalendar(dtTo);
        sbUrl.append(format.format(dtTo.getTime()));
        sbUrl.append("&accountId=");
        sbUrl.append(AppConfig.AccountID);

        return sbUrl.toString();
    }

    public static Payment[] getPayments()
    {
        GregorianCalendar dtFrom = new GregorianCalendar(2012, 4, 23);
        GregorianCalendar dtTo = new GregorianCalendar(2020, 4, 23);


        //String url = "https://mois-banking.herokuapp.com/v1/payment/findByDate?dateFrom=2012-04-23T18%3A25%3A43.511Z&dateTo=2020-04-23T18%3A25%3A43.511Z&accountId=9876";

        String url = getApiUrl("payment", dtFrom, dtTo);

        String json = HttpGetTask.GetDataFromUrl(url);
        if (StringUtil.isEmptyOrNull(json))
        {
            return null;
        }

        Payment[] item = JsonUtilsSafe.fromJson(json, Payment[].class);
        return item;
    }

    public static Transaction[] getTransactions()
    {
        // https://mois-banking.herokuapp.com/v1/transaction/findByDate?dateFrom=2019-02-18T14%3A02%3A29.346Z&dateTo=2019-02-18T18%3A02%3A29.346Z&accountId=9876

        GregorianCalendar dtFrom = new GregorianCalendar(2012, 4, 23);
        GregorianCalendar dtTo = new GregorianCalendar(2020, 4, 23);

        String url = getApiUrl("transaction", dtFrom, dtTo);

        String json = HttpGetTask.GetDataFromUrl(url);
        if (StringUtil.isEmptyOrNull(json))
        {
            return null;
        }

        Transaction[] item = JsonUtilsSafe.fromJson(json, Transaction[].class);
        return item;
    }

    public static Payment getPaymentById(String id)
    {
        // TODO
        Payment[] payments = getPayments();

        for (Payment p : payments)
        {
            if (id.equals(p.getId()))
                return p;
        }
        return null;
    }

    public static Transaction getTransactionById(String id)
    {
        // TODO
        Transaction[] transaction = getTransactions();

        for (Transaction tr : transaction)
        {
            if (id.equals(tr.getId()))
                return tr;
        }
        return null;
    }
}
