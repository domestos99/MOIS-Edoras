package cz.uhk.mois.edoras.services.imp;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.repositories.impl.PaymentMemoryCache;
import cz.uhk.mois.edoras.services.IPaymentService;
import cz.uhk.mois.edoras.utils.ListUtils;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPaymentService
{
    private final PaymentMemoryCache memoryCache;

    @Autowired
    public PaymentService(PaymentMemoryCache memoryCache)
    {
        this.memoryCache = memoryCache;
    }

    @Override
    public List<PaymentCategoryDTO> findAll()
    {
        List<Payment> payments = memoryCache.findAll();

        if (payments == null)
        {
            payments = ListUtils.toList(BankingApiFacade.getPayments());
        }

        List<PaymentCategoryDTO> result = new ArrayList<>();

        for (Payment p : payments)
        {
            PaymentCategoryDTO dto = new PaymentCategoryDTO();
            dto.setPayment(p);
            dto.setCategory(findCategoryForPayment(p));
            result.add(dto);
        }
        return result;
    }

    @Override
    public Optional<PaymentCategoryDTO> getById(String id)
    {
        Payment payment = memoryCache.findById(id);
        // Payment payment = Optional.of(BankingApiFacade.getPaymentById(id));

        // Not in cache
        if (payment == null)
        {
            // Try load from api
            payment = BankingApiFacade.getPaymentById(id);
        }
        if (payment == null) // Not Found at all
            return Optional.empty();

        PaymentCategoryDTO dto = new PaymentCategoryDTO();
        dto.setPayment(payment);

        dto.setCategory(findCategoryForPayment(payment));

        return Optional.of(dto);
    }

    private Category findCategoryForPayment(Payment payment)
    {
        return null;
    }


}
