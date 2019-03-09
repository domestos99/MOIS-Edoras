package cz.uhk.mois.edoras.repositories.impl;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.repositories.DAO.TransactionDAO;
import cz.uhk.mois.edoras.repositories.ICache;
import cz.uhk.mois.edoras.repositories.IRepositoryBase;
import cz.uhk.mois.edoras.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionCache implements IRepositoryBase<Transaction>, ICache<Transaction> {


    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionCache(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public void syncMemoryCache() {
        //TODO sync by something
    }

    @Override
    public void syncMemoryCache(List<Transaction> entities) {
        transactionDAO.saveAll(entities);
    }

    //@Scheduled(fixedRate = AppConfig.TIME_CACHE_SYNC)
    @Override
    public void refreshAll() {
        //TODO to treat fail if api is sleeping
        transactionDAO.deleteAll();
        transactionDAO.saveAll(ListUtils.toList(BankingApiFacade.getTransactions()));
    }

    @Override
    public int count() {
        return (int) transactionDAO.count();
    }

    @Override
    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }

    @Override
    public Transaction findById(String id) {
        return transactionDAO.findById(id).get();
    }

    @Override
    public Transaction save(Transaction entity) {
        return transactionDAO.save(entity);
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> entities) {
        return transactionDAO.saveAll(entities);
    }

    @Override
    public boolean delete(Transaction entity) {
        transactionDAO.delete(entity);
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        transactionDAO.deleteById(id);
        return true;
    }
}
