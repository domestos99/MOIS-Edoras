package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.repositories.DAO.PaymentDAO;
import cz.uhk.mois.edoras.services.IPaymentCategoryService;
import cz.uhk.mois.edoras.services.IPaymentService;
import cz.uhk.mois.edoras.utils.ListUtils;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryDTO;

@Service
public class PaymentService implements IPaymentService
{
    private final PaymentDAO paymentDAO;
    private final IPaymentCategoryService iPaymentCategoryService;


    @Autowired
    public PaymentService(PaymentDAO paymentDAO, IPaymentCategoryService iPaymentCategoryService)
    {
        this.paymentDAO = paymentDAO;
        this.iPaymentCategoryService = iPaymentCategoryService;
    }

    @Override
    public List<PaymentCategoryDTO> findAll()
    {
        List<Payment> payments = paymentDAO.findAll();

        List<PaymentCategoryDTO> result = new ArrayList<>();

        for (Payment p : payments)
        {
            PaymentCategoryDTO dto = new PaymentCategoryDTO();
            dto.setPayment(p);
            dto.setCategoryId(findCategoryForPayment(p));
            result.add(dto);
        }
        return result;
    }

    @Override
    public Optional<PaymentCategoryDTO> getById(String id)
    {
        Optional<Payment> payment = paymentDAO.findById(id);

        if (!payment.isPresent())
            return Optional.empty();

        PaymentCategoryDTO dto = new PaymentCategoryDTO();
        dto.setPayment(payment.get());

        dto.setCategoryId(findCategoryForPayment(payment.get()));

        return Optional.of(dto);
    }

    private String findCategoryForPayment(Payment payment)
    {
        return iPaymentCategoryService.getCategoryForPayment(payment);
    }


}
