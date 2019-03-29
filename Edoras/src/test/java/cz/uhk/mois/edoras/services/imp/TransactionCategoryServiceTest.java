//package cz.uhk.mois.edoras.services.imp;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import cz.uhk.mois.edoras.bankingapi.model.Transaction;
//import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;
//import cz.uhk.mois.edoras.domain.TransactionCategory;
//import cz.uhk.mois.edoras.repositories.DAO.TransactionCategoryDAO;
//import cz.uhk.mois.edoras.web.dto.ChangeType;
//import cz.uhk.mois.edoras.web.dto.TransactionCategoryUpdateDTO;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class TransactionCategoryServiceTest
//{
//
//    @Autowired
//    private TransactionCategoryDAO transactionCategoryDAO;
//
//    @Before
//    public void before()
//    {
//        transactionCategoryDAO.deleteAll();
//    }
//
//
//    @Test
//    public void updateTest1()
//    {
//        TransactionCategoryService service = new TransactionCategoryService(transactionCategoryDAO, transactionDAO, categoryDAO);
//
//        TransactionCategoryUpdateDTO dto = new TransactionCategoryUpdateDTO();
//
//        dto.setCategoryId("cate1");
//        dto.setChangeType(ChangeType.ALL);
//        dto.setTransactionId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        TransactionCategory res1 = service.update(dto);
//        Assert.assertNotNull(res1);
//
//        Transaction transaction = new Transaction();
//        transaction.setId("pay1");
//        transaction.setPartyAccount(createDummyAccount());
//
//        String cate = service.getCategoryForPayment(transaction);
//        Assert.assertEquals("cate1", cate);
//
//        Assert.assertEquals(1, transactionCategoryDAO.count());
//    }
//
//    @Test
//    public void updateTest2()
//    {
//        TransactionCategoryService service = new TransactionCategoryService(transactionCategoryDAO, transactionDAO, categoryDAO);
//
//        TransactionCategoryUpdateDTO dto = new TransactionCategoryUpdateDTO();
//
//        dto.setCategoryId("cate1");
//        dto.setChangeType(ChangeType.ONE);
//        dto.setTransactionId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        TransactionCategory res1 = service.update(dto);
//
//        Assert.assertNotNull(res1);
//
//        Transaction transaction = new Transaction();
//        transaction.setId("pay1");
//        transaction.setPartyAccount(createDummyAccount());
//
//        String cate = service.getCategoryForPayment(transaction);
//        Assert.assertEquals("cate1", cate);
//
//        Assert.assertEquals(1, transactionCategoryDAO.count());
//    }
//
//
//    @Test
//    public void updateTest3()
//    {
//        TransactionCategoryService service = new TransactionCategoryService(transactionCategoryDAO, transactionDAO, categoryDAO);
//
//        TransactionCategoryUpdateDTO dto = new TransactionCategoryUpdateDTO();
//
//        dto.setCategoryId("cate1");
//        dto.setChangeType(ChangeType.ONE);
//        dto.setTransactionId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        TransactionCategory res1 = service.update(dto);
//
//
//        TransactionCategoryUpdateDTO dto2 = new TransactionCategoryUpdateDTO();
//
//        dto2.setCategoryId("cate2");
//        dto2.setChangeType(ChangeType.ALL);
//        dto2.setTransactionId("pay2");
//        dto2.setTransactionPartyAccount(createDummyAccount());
//
//        TransactionCategory res2 = service.update(dto2);
//
//
//        Assert.assertNotNull(res1);
//
//        Transaction transaction = new Transaction();
//        transaction.setId("pay1");
//        transaction.setPartyAccount(createDummyAccount());
//
//        String cate = service.getCategoryForPayment(transaction);
//        Assert.assertEquals("cate1", cate);
//
//        Assert.assertEquals(2, transactionCategoryDAO.count());
//    }
//
//
//    @Test
//    public void updateTest4()
//    {
//        TransactionCategoryService service = new TransactionCategoryService(transactionCategoryDAO, transactionDAO, categoryDAO);
//
//        TransactionCategoryUpdateDTO dto = new TransactionCategoryUpdateDTO();
//
//        dto.setCategoryId("cate1");
//        dto.setChangeType(ChangeType.ONE);
//        dto.setTransactionId("pay1");
//        dto.setTransactionPartyAccount(createDummyAccount());
//
//        TransactionCategory res1 = service.update(dto);
//
//
//        TransactionCategoryUpdateDTO dto2 = new TransactionCategoryUpdateDTO();
//
//        dto2.setCategoryId("cate2");
//        dto2.setChangeType(ChangeType.ALL);
//        dto2.setTransactionId("pay1");
//        dto2.setTransactionPartyAccount(createDummyAccount());
//
//        TransactionCategory res2 = service.update(dto2);
//
//
//        Assert.assertNotNull(res1);
//
//        Transaction transaction = new Transaction();
//        transaction.setId("pay1");
//        transaction.setPartyAccount(createDummyAccount());
//
//        String cate = service.getCategoryForPayment(transaction);
//        Assert.assertEquals("cate2", cate);
//
//        Assert.assertEquals(1, transactionCategoryDAO.count());
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
