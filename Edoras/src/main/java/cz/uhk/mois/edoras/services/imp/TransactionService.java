package cz.uhk.mois.edoras.services.imp;

import cz.uhk.mois.edoras.dao.CategoryDAO;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.dao.TransactionDAO;
import cz.uhk.mois.edoras.services.ITransactionService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;
import cz.uhk.mois.edoras.web.dto.TransactionFilterModel;

@Service
public class TransactionService implements ITransactionService {
    private final TransactionDAO transactionDAO;
    private final CategoryDAO categoryDAO;

    @Autowired
    public TransactionService(TransactionDAO transactionDAO, CategoryDAO categoryDAO) {
        this.transactionDAO = transactionDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<TransactionCategoryDTO> findAll(TransactionFilterModel filterModel) {
        List<Transaction> transactions = new ArrayList<>();


        if (StringUtil.isEmptyOrNull(filterModel.getCateId()) && filterModel.getDtFrom() == null && filterModel.getDtTo() == null) {
            transactions = transactionDAO.findAll(new Sort(Sort.Direction.DESC, "ValueDate"));
        } else if (filterModel.getDtFrom() != null && filterModel.getDtTo() != null && StringUtil.isEmptyOrNull(filterModel.getCateId())) {
            transactions = transactionDAO.findByValueDateBetweenOrderByValueDateDesc(filterModel.getDtFrom(), filterModel.getDtTo());
        } else if (filterModel.getDtTo() == null && filterModel.getDtFrom() == null && !StringUtil.isEmptyOrNull(filterModel.getCateId())) {

            Optional<Category> category = categoryDAO.findById(filterModel.getCateId());
            if (category.isPresent()) {
                transactions = transactionDAO.findByCategoryOrderByValueDateDesc(category.get());
            }

        } else if (filterModel.getCateId() != null && filterModel.getDtFrom() != null && filterModel.getDtTo() != null) {

            Optional<Category> category = categoryDAO.findById(filterModel.getCateId());
            if (category.isPresent()) {
                transactions = transactionDAO.findByValueDateBetweenAndCategoryOrderByValueDateDesc(filterModel.getDtFrom(), filterModel.getDtTo(), category.get());
            }
        }


        List<TransactionCategoryDTO> result = new ArrayList<>();

        for (Transaction p : transactions) {
            TransactionCategoryDTO dto = new TransactionCategoryDTO();
            dto.setTransaction(p);
            result.add(dto);
        }
        return result;
    }

    @Override
    public Optional<TransactionCategoryDTO> getById(String id) {
        Optional<Transaction> transaction = transactionDAO.findById(id);

        if (!transaction.isPresent())
            return Optional.empty();

        TransactionCategoryDTO dto = new TransactionCategoryDTO();
        dto.setTransaction(transaction.get());

        return Optional.of(dto);
    }

}
