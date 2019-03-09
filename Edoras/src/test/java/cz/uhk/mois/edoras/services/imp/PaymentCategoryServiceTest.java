package cz.uhk.mois.edoras.services.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.repositories.DAO.PaymentCategoryDAO;
import cz.uhk.mois.edoras.web.dto.ChangeType;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentCategoryServiceTest
{

    @Autowired
    private PaymentCategoryDAO paymentCategoryService;

    @Before
    public void before()
    {
        paymentCategoryService.deleteAll();
    }


    @Test
    public void updateTest1()
    {
        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService);

        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();

        dto.setCategoryId("cate1");
        dto.setChangeType(ChangeType.ALL);
        dto.setPaymentId("pay1");
        dto.setTransactionPartyAccount(createDummyAccount());

        PaymentCategory res1 = service.update(dto);
        Assert.assertNotNull(res1);

        Payment payment = new Payment();
        payment.setId("pay1");
        payment.setPartyAccount(createDummyAccount());

        String cate = service.getCategoryForPayment(payment);
        Assert.assertEquals("cate1", cate);

        Assert.assertEquals(1, paymentCategoryService.count());
    }

    @Test
    public void updateTest2()
    {
        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService);

        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();

        dto.setCategoryId("cate1");
        dto.setChangeType(ChangeType.ONE);
        dto.setPaymentId("pay1");
        dto.setTransactionPartyAccount(createDummyAccount());

        PaymentCategory res1 = service.update(dto);

        Assert.assertNotNull(res1);

        Payment payment = new Payment();
        payment.setId("pay1");
        payment.setPartyAccount(createDummyAccount());

        String cate = service.getCategoryForPayment(payment);
        Assert.assertEquals("cate1", cate);

        Assert.assertEquals(1, paymentCategoryService.count());
    }


    @Test
    public void updateTest3()
    {
        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService);

        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();

        dto.setCategoryId("cate1");
        dto.setChangeType(ChangeType.ONE);
        dto.setPaymentId("pay1");
        dto.setTransactionPartyAccount(createDummyAccount());

        PaymentCategory res1 = service.update(dto);


        PaymentCategoryUpdateDTO dto2 = new PaymentCategoryUpdateDTO();

        dto2.setCategoryId("cate2");
        dto2.setChangeType(ChangeType.ALL);
        dto2.setPaymentId("pay2");
        dto2.setTransactionPartyAccount(createDummyAccount());

        PaymentCategory res2 = service.update(dto2);


        Assert.assertNotNull(res1);

        Payment payment = new Payment();
        payment.setId("pay1");
        payment.setPartyAccount(createDummyAccount());

        String cate = service.getCategoryForPayment(payment);
        Assert.assertEquals("cate1", cate);

        Assert.assertEquals(2, paymentCategoryService.count());
    }


    @Test
    public void updateTest4()
    {
        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService);

        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();

        dto.setCategoryId("cate1");
        dto.setChangeType(ChangeType.ONE);
        dto.setPaymentId("pay1");
        dto.setTransactionPartyAccount(createDummyAccount());

        PaymentCategory res1 = service.update(dto);


        PaymentCategoryUpdateDTO dto2 = new PaymentCategoryUpdateDTO();

        dto2.setCategoryId("cate2");
        dto2.setChangeType(ChangeType.ALL);
        dto2.setPaymentId("pay1");
        dto2.setTransactionPartyAccount(createDummyAccount());

        PaymentCategory res2 = service.update(dto2);


        Assert.assertNotNull(res1);

        Payment payment = new Payment();
        payment.setId("pay1");
        payment.setPartyAccount(createDummyAccount());

        String cate = service.getCategoryForPayment(payment);
        Assert.assertEquals("cate2", cate);

        Assert.assertEquals(1, paymentCategoryService.count());
    }

    private TransactionPartyAccount createDummyAccount()
    {
        TransactionPartyAccount account = new TransactionPartyAccount();
        account.setAccountNumber("123");
        account.setPrefix("77");
        account.setAccountNumber("1010");
        return account;

    }


}