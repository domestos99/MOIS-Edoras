//package cz.uhk.mois.edoras.services.imp;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import cz.uhk.mois.edoras.bankingapi.model.Payment;
//import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;
//import cz.uhk.mois.edoras.dao.CategoryDAO;
//import cz.uhk.mois.edoras.domain.Category;
//import cz.uhk.mois.edoras.domain.PaymentCategory;
//import cz.uhk.mois.edoras.dao.PaymentCategoryDAO;
//import cz.uhk.mois.edoras.dao.PaymentDAO;
//import cz.uhk.mois.edoras.web.dto.ChangeType;
//import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class PaymentCategoryServiceTest
//{
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//
//    @Autowired
//    private PaymentCategoryDAO paymentCategoryService;
//
//    @Autowired
//    private PaymentDAO paymentDAO;
//
//    @Autowired
//    private CategoryDAO categoryDAO;
//
//    @Before
//    public void before()
//    {
//        paymentCategoryService.deleteAll();
//    }
//
//
//    List<Category> categoryList = Arrays.asList(
//            new Category("cate_id_1", "cate_name_1", "cate_icon_1", "cate_type_1"),
//            new Category("cate_id_2", "cate_name_2", "cate_icon_2", "cate_type_2")
//    );
//
//
//    @Test
//    public void updateTest1()
//    {
//        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService, paymentDAO, categoryDAO);
//
//        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();
//
//        Payment payment = getTestPayment(1);
//        payment = paymentDAO.save(payment);
//
//        Category cate = getTestCategory(1);
//
//        dto.setCategoryId(cate.getId());
//        dto.setChangeType(ChangeType.ALL);
//        dto.setPaymentId(payment.getId());
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        PaymentCategory res1 = service.update(dto);
//        Assert.assertNotNull(res1);
//
//
//        Optional<Payment> paymentOpt = paymentDAO.findById(payment.getId());
//
//        Assert.assertTrue(paymentOpt.isPresent());
//
//        Payment p = paymentOpt.get();
//
//        Assert.assertNotNull(p.getCategory());
//        Assert.assertEquals(cate.getId(), p.getCategory().getId());
//        Assert.assertEquals(1, paymentCategoryService.count());
//    }
//
//
//    @Test
//    public void updateTest2()
//    {
//        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService, paymentDAO, categoryDAO);
//
//        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();
//
//        Category cate = getTestCategory(1);
//        dto.setCategoryId(cate.getId());
//        dto.setChangeType(ChangeType.ONE);
//        dto.setPaymentId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        PaymentCategory res1 = service.update(dto);
//
//        Assert.assertNotNull(res1);
//
//        Payment payment = new Payment();
//        payment.setId("pay1");
//        payment.setPartyAccount(createDummyAccount());
//
////        String cate = service.getCategoryForPayment(payment);
////        Assert.assertEquals("cate1", cate);
////
////        Assert.assertEquals(1, paymentCategoryService.count());
//    }
//
//
//    @Test
//    public void updateTest3()
//    {
//        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService, paymentDAO, categoryDAO);
//
//        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();
//
//        Category cate = getTestCategory(1);
//        dto.setCategoryId(cate.getId());
//        dto.setChangeType(ChangeType.ONE);
//        dto.setPaymentId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        PaymentCategory res1 = service.update(dto);
//
//
//        PaymentCategoryUpdateDTO dto2 = new PaymentCategoryUpdateDTO();
//
//        Category cate2 = getTestCategory(2);
//        dto2.setCategoryId(cate2.getId());
//        dto2.setChangeType(ChangeType.ALL);
//        dto2.setPaymentId("pay2");
//        dto2.setTransactionPartyAccount(createDummyAccount());
//
//        PaymentCategory res2 = service.update(dto2);
//
//
//        Assert.assertNotNull(res1);
//
//        Payment payment = new Payment();
//        payment.setId("pay1");
//        payment.setPartyAccount(createDummyAccount());
//
////        String cate = service.getCategoryForPayment(payment);
////        Assert.assertEquals("cate1", cate);
////
////        Assert.assertEquals(2, paymentCategoryService.count());
//    }
//
//
//    @Test
//    public void updateTest4()
//    {
//        PaymentCategoryService service = new PaymentCategoryService(paymentCategoryService, paymentDAO, categoryDAO);
//
//        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();
//
//        Category cate = getTestCategory(1);
//        dto.setCategoryId(cate.getId());
//        dto.setChangeType(ChangeType.ONE);
//        dto.setPaymentId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        PaymentCategory res1 = service.update(dto);
//
//
//        PaymentCategoryUpdateDTO dto2 = new PaymentCategoryUpdateDTO();
//
//        Category cate2 = getTestCategory(1);
//        dto2.setCategoryId(cate2.getId());
//        dto2.setChangeType(ChangeType.ALL);
//        dto2.setPaymentId("pay1");
//        dto2.setTransactionPartyAccount(createDummyAccount());
//
//        PaymentCategory res2 = service.update(dto2);
//
//
//        Assert.assertNotNull(res1);
//
//        Payment payment = new Payment();
//        payment.setId("pay1");
//        payment.setPartyAccount(createDummyAccount());
//
////        String cate = service.getCategoryForPayment(payment);
////        Assert.assertEquals("cate2", cate);
////
////        Assert.assertEquals(1, paymentCategoryService.count());
//    }
//
//
//    private Payment getTestPayment(int nameIndex)
//    {
//        Payment p = new Payment();
//
//        p.setId("payment_index_" + nameIndex);
//        p.setPartyAccount(createDummyAccount());
//
//        return p;
//    }
//
//    private Category getTestCategory(int nameIndex)
//    {
//        Category c = new Category();
//        c.setId("cate_id_" + nameIndex);
//        c.setName("cate_name_" + nameIndex);
//        return c;
//    }
//
//    private TransactionPartyAccount createDummyAccount()
//    {
//        TransactionPartyAccount account = new TransactionPartyAccount();
//        account.setAccountNumber("123");
//        account.setPrefix("77");
//        account.setAccountNumber("1010");
//        return account;
//
//    }
//
//
//}
