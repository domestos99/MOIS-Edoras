package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.helpers.imp.AccountHelper;
import cz.uhk.mois.edoras.repositories.DAO.PaymentCategoryDAO;
import cz.uhk.mois.edoras.services.IPaymentCategoryService;

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
}
