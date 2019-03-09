package cz.uhk.mois.edoras.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.logger.LoggerFacade;
import cz.uhk.mois.edoras.repositories.DAO.PaymentDAO;
import cz.uhk.mois.edoras.repositories.DAO.TransactionDAO;
import cz.uhk.mois.edoras.utils.ListUtils;

@Service
public class BankingApiSyncJob
{
    private final PaymentDAO paymentDAO;
    private final TransactionDAO transactionDAO;

    @Autowired
    public BankingApiSyncJob(final PaymentDAO paymentDAO, final TransactionDAO transactionDAO)
    {
        this.paymentDAO = paymentDAO;
        this.transactionDAO = transactionDAO;
    }

    // every 10 seconds
    // @Scheduled(cron = "*/10 * * * * *")
    // Every midnight
    @Scheduled(cron = "0 0 0 * * *")
    public void syncPaymentsAndTransactions()
    {
        LoggerFacade.log("Start syncPaymentsAndTransactions");
        syncTransactions();
        syncPayments();
        LoggerFacade.log("End syncPaymentsAndTransactions");
    }

    private void syncPayments()
    {
        Payment[] payments = BankingApiFacade.getPayments();
        if (payments != null)
        {
            paymentDAO.saveAll(ListUtils.toList(payments));
        }
    }

    private void syncTransactions()
    {
        Transaction[] transactions = BankingApiFacade.getTransactions();
        if (transactions != null)
        {
            transactionDAO.saveAll(ListUtils.toList(transactions));
        }
    }
}
