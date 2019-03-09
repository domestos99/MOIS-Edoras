package cz.uhk.mois.edoras.repositories.impl;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.repositories.ICache;
import cz.uhk.mois.edoras.repositories.DAO.PaymentDAO;
import cz.uhk.mois.edoras.repositories.IRepositoryBase;
import cz.uhk.mois.edoras.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentCache implements IRepositoryBase<Payment>, ICache<Payment> {

    private PaymentDAO paymentDAO;

    @Autowired
    public PaymentCache(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }


    @Override
    public void syncMemoryCache() {
        //TODO sync by something
    }

    @Override
    public void syncMemoryCache(List<Payment> entities) {
        paymentDAO.saveAll(entities);
    }

    //@Scheduled(fixedRate = AppConfig.TIME_CACHE_SYNC)
    @Override
    public void refreshAll() {
        //TODO to treat fail if api is sleeping
        paymentDAO.deleteAll();
        paymentDAO.saveAll(ListUtils.toList(BankingApiFacade.getPayments()));
    }


    @Override
    public int count() {
        return (int) paymentDAO.count();
    }

    @Override
    public List<Payment> findAll() {
        return paymentDAO.findAll();
    }

    @Override
    public Payment findById(String id) {
        return paymentDAO.findById(id).get();
    }

    @Override
    public Payment save(Payment entity) {
        return paymentDAO.save(entity);
    }

    @Override
    public List<Payment> saveAll(List<Payment> entities) {
        return paymentDAO.saveAll(entities);
    }

    @Override
    public boolean delete(Payment entity) {
        paymentDAO.delete(entity);
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        paymentDAO.deleteById(id);
        return true;
    }
}
