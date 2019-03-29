package cz.uhk.mois.edoras.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.dao.PaymentDAO;
import cz.uhk.mois.edoras.dao.TransactionDAO;
import cz.uhk.mois.edoras.logger.LoggerFacade;
import cz.uhk.mois.edoras.services.imp.PaymentCategoryService;
import cz.uhk.mois.edoras.services.imp.TransactionCategoryService;
import cz.uhk.mois.edoras.utils.ListUtils;

@Service
public class BankingApiSyncJob
{
    private final PaymentDAO paymentDAO;
    private final TransactionDAO transactionDAO;
    private final PaymentCategoryService paymentCategoryService;
    private final TransactionCategoryService transactionCategoryService;

    @Autowired
    public BankingApiSyncJob(final PaymentDAO paymentDAO, final TransactionDAO transactionDAO, PaymentCategoryService paymentCategoryService, TransactionCategoryService transactionCategoryService)
    {
        this.paymentDAO = paymentDAO;
        this.transactionDAO = transactionDAO;
        this.paymentCategoryService = paymentCategoryService;
        this.transactionCategoryService = transactionCategoryService;
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
        List<Payment> updatedPayments = paymentCategoryService.updatePaymentCategories(ListUtils.toList(payments));
        if (payments != null)
        {
            paymentDAO.saveAll(updatedPayments);
        }
    }

    private void syncTransactions()
    {
        Transaction[] transactions = BankingApiFacade.getTransactions();
        List<Transaction> updatedTransactions = transactionCategoryService.updateTransactionCategory(ListUtils.toList(transactions));
        if (transactions != null)
        {
            transactionDAO.saveAll(updatedTransactions);
        }
    }
}
