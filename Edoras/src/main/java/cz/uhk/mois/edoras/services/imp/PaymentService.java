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

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.dao.PaymentDAO;
import cz.uhk.mois.edoras.services.IPaymentService;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryDTO;
import cz.uhk.mois.edoras.web.dto.PaymentFilterModel;

@Service
public class PaymentService implements IPaymentService {


    private final PaymentDAO paymentDAO;

    private final CategoryDAO categoryDAO;


    @Autowired
    public PaymentService(PaymentDAO paymentDAO, CategoryDAO categoryDAO) {
        this.paymentDAO = paymentDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<PaymentCategoryDTO> findAll(final PaymentFilterModel filterModel) {
        List<Payment> payments = new ArrayList<>();

        if (filterModel.getDtTo() == null || filterModel.getDtFrom() == null) {
            filterModel.setDtFrom(null);
            filterModel.setDtTo(null);
        }


        if (StringUtil.isEmptyOrNull(filterModel.getCateId()) && filterModel.getDtFrom() == null && filterModel.getDtTo() == null) {
            payments = paymentDAO.findAll(new Sort(Sort.Direction.DESC, "category.name"));
        } else if (filterModel.getDtFrom() != null && filterModel.getDtTo() != null && StringUtil.isEmptyOrNull(filterModel.getCateId())) {
            payments = paymentDAO.findByDueDateBetweenOrderByCategoryDesc(filterModel.getDtFrom(), filterModel.getDtTo());
        } else if (filterModel.getDtTo() == null && filterModel.getDtFrom() == null && !StringUtil.isEmptyOrNull(filterModel.getCateId())) {

            Optional<Category> category = categoryDAO.findById(filterModel.getCateId());
            if (category.isPresent()) {
                payments = paymentDAO.findByCategory(category.get());
            }

        } else if (filterModel.getCateId() != null && filterModel.getDtFrom() != null && filterModel.getDtTo() != null) {

            Optional<Category> category = categoryDAO.findById(filterModel.getCateId());
            if (category.isPresent()) {
                payments = paymentDAO.findByDueDateBetweenAndCategoryOrderByCategoryDesc(filterModel.getDtFrom(), filterModel.getDtTo(), category.get());
            }
        }


        List<PaymentCategoryDTO> result = new ArrayList<>();
        for (Payment p : payments) {
            PaymentCategoryDTO dto = new PaymentCategoryDTO();
            dto.setPayment(p);
            result.add(dto);
        }
        return result;
    }

    @Override
    public Optional<PaymentCategoryDTO> getById(String id) {
        Optional<Payment> payment = paymentDAO.findById(id);

        if (!payment.isPresent())
            return Optional.empty();

        PaymentCategoryDTO dto = new PaymentCategoryDTO();
        dto.setPayment(payment.get());

        return Optional.of(dto);
    }


}
