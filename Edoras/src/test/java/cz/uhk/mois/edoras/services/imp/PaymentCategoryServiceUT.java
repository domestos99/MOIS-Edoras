package cz.uhk.mois.edoras.services.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;
import cz.uhk.mois.edoras.dao.CategoryDAO;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.dao.PaymentCategoryDAO;
import cz.uhk.mois.edoras.dao.PaymentDAO;
import cz.uhk.mois.edoras.web.dto.ChangeType;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class PaymentCategoryServiceUT
{
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    List<Category> categoryList = Arrays.asList(
            new Category("cate_id_1", "cate_name_1", "cate_icon_1", "cate_type_1"),
            new Category("cate_id_2", "cate_name_2", "cate_icon_2", "cate_type_2")
    );

    List<Payment> paymentList;
    Payment paymentToTest;

    @Before
    public void before()
    {
        //paymentCategoryService = new PaymentCategoryService(paymentCategoryDAO, paymentDAO, categoryDAO);

        Payment payment1 = new Payment();
        payment1.setId("payment_id_1");

        TransactionPartyAccount account1 = new TransactionPartyAccount();
        account1.setAccountNumber("xxx");
        account1.setPrefix("yyy");
        account1.setBankCode("zzz");
        payment1.setPartyAccount(account1);


        Payment payment2 = new Payment();
        payment2.setId("payment_id_2");
        payment2.setPartyAccount(account1);

        paymentList = Arrays.asList(
                payment1, payment2);

        paymentToTest = paymentList.get(0);
    }

    Category categoryToTest = categoryList.get(0);

    @Mock
    private PaymentCategoryDAO paymentCategoryDAO;
    @Mock
    private PaymentDAO paymentDAO;
    @Mock
    private CategoryDAO categoryDAO;

    @InjectMocks
    private PaymentCategoryService paymentCategoryService; // = new PaymentCategoryService(paymentCategoryDAO, paymentDAO, categoryDAO);


    @Test
    public void update1()
    {
        when(paymentCategoryDAO.findByPaymentId(anyString())).thenReturn(null);
        when(paymentCategoryDAO.findByPaymentAccount(anyString())).thenReturn(null);
        when(paymentCategoryDAO.save(any(PaymentCategory.class))).thenAnswer(new Answer<PaymentCategory>()
        {
            @Override
            public PaymentCategory answer(InvocationOnMock invocation) throws Throwable
            {
                Object[] args = invocation.getArguments();
                PaymentCategory c = (PaymentCategory) args[0];
                c.setId(UUID.randomUUID().toString());
                return c;
            }
        });


        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();
        dto.setCategoryId(categoryToTest.getId());
        dto.setChangeType(ChangeType.ALL);
        dto.setPaymentId(paymentToTest.getId());
        dto.setTransactionPartyAccount(paymentToTest.getPartyAccount());


        PaymentCategory category = paymentCategoryService.update(dto);


        Assert.assertNotNull(category);
        Assert.assertEquals(categoryToTest.getId(), category.getCategoryId());
        Assert.assertNull(category.getPaymentId());
    }


    @Test
    public void update2()
    {
        when(paymentCategoryDAO.findByPaymentId(anyString())).thenReturn(null);
        when(paymentCategoryDAO.findByPaymentAccount(anyString())).thenReturn(null);
        when(paymentCategoryDAO.save(any(PaymentCategory.class))).thenAnswer(new Answer<PaymentCategory>()
        {
            @Override
            public PaymentCategory answer(InvocationOnMock invocation) throws Throwable
            {
                Object[] args = invocation.getArguments();
                PaymentCategory c = (PaymentCategory) args[0];
                c.setId(UUID.randomUUID().toString());
                return c;
            }
        });

        PaymentCategoryUpdateDTO dto = new PaymentCategoryUpdateDTO();
        dto.setCategoryId(categoryToTest.getId());
        dto.setChangeType(ChangeType.ALL);
        dto.setPaymentId(paymentToTest.getId());
        dto.setTransactionPartyAccount(paymentToTest.getPartyAccount());

        final PaymentCategory category = paymentCategoryService.update(dto);

        Assert.assertNotNull(category);
        Assert.assertEquals(categoryToTest.getId(), category.getCategoryId());
        Assert.assertNull(category.getPaymentId());


        when(paymentCategoryDAO.findByPaymentAccount(anyString())).thenAnswer(new Answer<PaymentCategory>()
        {
            @Override
            public PaymentCategory answer(InvocationOnMock invocation) throws Throwable
            {
                return category;
            }
        });


        PaymentCategoryUpdateDTO dto2 = new PaymentCategoryUpdateDTO();
        dto2.setCategoryId(categoryToTest.getId());
        dto2.setChangeType(ChangeType.ONE);
        dto2.setPaymentId(paymentToTest.getId());
        dto2.setTransactionPartyAccount(paymentToTest.getPartyAccount());


        final PaymentCategory category2 = paymentCategoryService.update(dto2);


        Assert.assertNotNull(category2);
        Assert.assertEquals(categoryToTest.getId(), category2.getCategoryId());
        Assert.assertNotNull(category2.getPaymentId());
        Assert.assertNull(category2.getPaymentAccount());
    }



    @Test
    public void update_dto_nul_test()
    {
        final PaymentCategory category = paymentCategoryService.update(null);
        Assert.assertNull(category);
    }


    @Test
    public void getCategoryForPayment1Test()
    {
        when(paymentCategoryDAO.findByPaymentId(paymentToTest.getId())).thenAnswer(new Answer<PaymentCategory>()
        {
            @Override
            public PaymentCategory answer(InvocationOnMock invocation) throws Throwable
            {
                Object[] args = invocation.getArguments();
                String paymentId = (String) args[0];

                PaymentCategory pc = new PaymentCategory();
                pc.setId(UUID.randomUUID().toString());
                pc.setPaymentId(paymentId);
                pc.setCategoryId(categoryToTest.getId());
                return pc;
            }
        });
        when(categoryDAO.findById(categoryToTest.getId())).thenReturn(Optional.of(categoryToTest));

        Category category = paymentCategoryService.getCategoryForPayment(paymentToTest);

        Assert.assertNotNull(category);
        Assert.assertEquals(categoryToTest.getId(), category.getId());
    }


    @Test
    public void getCategoryForPayment2Test()
    {
        when(paymentCategoryDAO.findByPaymentId(paymentToTest.getId())).thenReturn(null);

        when(paymentCategoryDAO.findByPaymentAccount(anyString())).thenAnswer(new Answer<PaymentCategory>()
        {
            @Override
            public PaymentCategory answer(InvocationOnMock invocation) throws Throwable
            {
                Object[] args = invocation.getArguments();
                String account = (String) args[0];

                PaymentCategory pc = new PaymentCategory();
                pc.setId(UUID.randomUUID().toString());
                pc.setPaymentId(null);
                pc.setPaymentAccount(account);
                pc.setCategoryId(categoryToTest.getId());
                return pc;
            }
        });
        when(categoryDAO.findById(categoryToTest.getId())).thenReturn(Optional.of(categoryToTest));

        Category category = paymentCategoryService.getCategoryForPayment(paymentToTest);

        Assert.assertNotNull(category);
        Assert.assertEquals(categoryToTest.getId(), category.getId());
    }


    @Test
    public void getCategoryForPayment3Test()
    {
        when(paymentCategoryDAO.findByPaymentId(paymentToTest.getId())).thenReturn(null);

        when(paymentCategoryDAO.findByPaymentAccount(anyString())).thenReturn(null);

        when(categoryDAO.findById(categoryToTest.getId())).thenReturn(Optional.of(categoryToTest));

        Category category = paymentCategoryService.getCategoryForPayment(paymentToTest);

        Assert.assertNull(category);
    }

    @Test
    public void getCategoryForPayment4Test()
    {
        when(paymentCategoryDAO.findByPaymentId(paymentToTest.getId())).thenAnswer(new Answer<PaymentCategory>()
        {
            @Override
            public PaymentCategory answer(InvocationOnMock invocation) throws Throwable
            {
                Object[] args = invocation.getArguments();
                String paymentId = (String) args[0];

                PaymentCategory pc = new PaymentCategory();
                pc.setId(UUID.randomUUID().toString());
                pc.setPaymentId(paymentId);
                pc.setCategoryId(categoryToTest.getId());
                return pc;
            }
        });
        when(categoryDAO.findById(categoryToTest.getId())).thenReturn(Optional.empty());

        Category category = paymentCategoryService.getCategoryForPayment(paymentToTest);

        Assert.assertNull(category);
    }











}
