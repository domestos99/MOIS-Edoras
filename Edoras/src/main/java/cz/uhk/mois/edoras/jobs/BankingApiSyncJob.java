package cz.uhk.mois.edoras.jobs;

import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.repositories.DAO.CategoryDAO;
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

import java.util.List;

@Service
public class BankingApiSyncJob {
    private final PaymentDAO paymentDAO;
    private final TransactionDAO transactionDAO;
    private final CategoryDAO categoryDAO;

    @Autowired
    public BankingApiSyncJob(final PaymentDAO paymentDAO, final TransactionDAO transactionDAO, final CategoryDAO categoryDAO) {
        this.paymentDAO = paymentDAO;
        this.transactionDAO = transactionDAO;
        this.categoryDAO = categoryDAO;
    }

    // every 10 seconds
    @Scheduled(cron = "*/10 * * * * *")
    // Every midnight
    //@Scheduled(cron = "0 0 0 * * *")
    public void syncPaymentsAndTransactions() {
        LoggerFacade.log("Start syncPaymentsAndTransactions");
        syncTransactions();
        syncPayments();
        LoggerFacade.log("End syncPaymentsAndTransactions");
    }

    private void syncPayments() {
        Payment[] payments = BankingApiFacade.getPayments();
        if (payments != null) {

            List<Payment> paymentList = ListUtils.toList(payments);
            setPaymentCategory(paymentList);
            paymentDAO.saveAll(paymentList);
        }
    }

    private void syncTransactions() {
        Transaction[] transactions = BankingApiFacade.getTransactions();
        if (transactions != null) {
            transactionDAO.saveAll(ListUtils.toList(transactions));
        }
    }

    private void setPaymentCategory(List<Payment> payments) {

        List<Category> categories = categoryDAO.findAll();
        for (Payment payment : payments) {
            for (Category category : categories) {
                for (Payment paymentInCategory : category.getPayments()) {
                    if (paymentInCategory.getId().equals(payment.getId())) {
                        payment.setCategory(category);
                    }
                }
            }
        }
    }
}
