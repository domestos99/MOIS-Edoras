package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.helpers.imp.AccountHelper;
import cz.uhk.mois.edoras.repositories.DAO.PaymentCategoryDAO;
import cz.uhk.mois.edoras.services.IPaymentCategoryService;
import cz.uhk.mois.edoras.web.dto.ChangeType;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;

@Service
public class PaymentCategoryService implements IPaymentCategoryService
{
    private final PaymentCategoryDAO paymentCategoryDAO;

    @Autowired
    public PaymentCategoryService(PaymentCategoryDAO paymentCategoryDAO)
    {
        this.paymentCategoryDAO = paymentCategoryDAO;
    }

    @Override
    public String getCategoryForPayment(final Payment payment)
    {
        String id = payment.getId();

        PaymentCategory category = paymentCategoryDAO.findByPaymentId(id);

        if (category == null)
        {
            String account = AccountHelper.getAccountId(payment.getPartyAccount());
            category = paymentCategoryDAO.findByPaymentAccount(account);
        }
        if (category == null)
            return null;
        return category.getCategoryId();
    }


    @Override
    public PaymentCategory update(PaymentCategoryUpdateDTO paymentCategoryUpdateDTO)
    {
        PaymentCategory paymentCategory = new PaymentCategory();

        if (paymentCategoryUpdateDTO == null)
        {
            return null;
        }

        paymentCategory.setCategoryId(paymentCategoryUpdateDTO.getCategoryId());

        if (paymentCategoryUpdateDTO.getChangeType() == ChangeType.ONE)
        {
            paymentCategory.setPaymentId(paymentCategoryUpdateDTO.getPaymentId());
        }
        else
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


        return paymentCategoryDAO.save(paymentCategory);
    }
}
