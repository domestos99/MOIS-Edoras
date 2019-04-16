package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.dao.CategoryDAO;
import cz.uhk.mois.edoras.dao.PaymentCategoryDAO;
import cz.uhk.mois.edoras.dao.PaymentDAO;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.helpers.AccountHelper;
import cz.uhk.mois.edoras.services.IPaymentCategoryService;
import cz.uhk.mois.edoras.web.dto.ChangeType;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;

@Service
public class PaymentCategoryService implements IPaymentCategoryService
{
    private final PaymentCategoryDAO paymentCategoryDAO;
    private final PaymentDAO paymentDAO;
    private final CategoryDAO categoryDAO;

    @Autowired
    public PaymentCategoryService(PaymentCategoryDAO paymentCategoryDAO, PaymentDAO paymentDAO, CategoryDAO categoryDAO)
    {
        this.paymentCategoryDAO = paymentCategoryDAO;
        this.paymentDAO = paymentDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public PaymentCategory update(final PaymentCategoryUpdateDTO paymentCategoryUpdateDTO)
    {
        final PaymentCategory paymentCategory = new PaymentCategory();

        if (paymentCategoryUpdateDTO == null)
        {
            return null;
        }

        paymentCategory.setCategoryId(paymentCategoryUpdateDTO.getCategoryId());

        if (paymentCategoryUpdateDTO.getChangeType() == ChangeType.ONE)
        {
            paymentCategory.setPaymentId(paymentCategoryUpdateDTO.getPaymentId());

            PaymentCategory pc = paymentCategoryDAO.findByPaymentId(paymentCategoryUpdateDTO.getPaymentId());
            if (pc != null)
            {
                paymentCategory.setId(pc.getId());
            }
        }
        else if (paymentCategoryUpdateDTO.getChangeType() == ChangeType.ALL)
        {
            // for ALL
            paymentCategory.setPaymentAccount(AccountHelper.getAccountId(paymentCategoryUpdateDTO.getTransactionPartyAccount()));

            // Load ID if exists
            // Try find by paymentID
            PaymentCategory pc = paymentCategoryDAO.findByPaymentId(paymentCategoryUpdateDTO.getPaymentId());
            if (pc != null)
            {
                paymentCategoryDAO.delete(pc);
                pc = null;
            }
            if (pc == null)
            {
                // Try find by account
                pc = paymentCategoryDAO.findByPaymentAccount(AccountHelper.getAccountId(paymentCategoryUpdateDTO.getTransactionPartyAccount()));
            }

            if (pc != null)
            {
                paymentCategory.setId(pc.getId());
            }
        }
        else
        {
            throw new RuntimeException("Invalid ChangeType");
        }

        PaymentCategory pc = paymentCategoryDAO.save(paymentCategory);
        updatePaymentCategories(paymentDAO.findAll());
        return pc;
    }

    public List<Payment> updatePaymentCategories(List<Payment> paymentList)
    {
        for (Payment p : paymentList)
        {
            p.setCategory(getCategoryForPayment(p));
        }
        paymentDAO.saveAll(paymentList);
        return paymentList;
    }

    Category getCategoryForPayment(final Payment payment)
    {
        final String id = payment.getId();

        PaymentCategory category = paymentCategoryDAO.findByPaymentId(id);

        if (category == null)
        {
            String account = AccountHelper.getAccountId(payment.getPartyAccount());
            category = paymentCategoryDAO.findByPaymentAccount(account);
        }
        if (category == null)
            return null;

        return getCategoryById(category.getCategoryId());
    }

    private Category getCategoryById(String cateId)
    {
        Optional<Category> cateOpt = categoryDAO.findById(cateId);
        return cateOpt.orElse(null);
    }


}
