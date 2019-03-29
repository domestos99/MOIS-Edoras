package cz.uhk.mois.edoras.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.utils.JsonUtilsSafe;
import cz.uhk.mois.edoras.utils.ListUtils;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentDAOTest
{
    @Autowired
    private PaymentDAO paymentDAO;

    @Test
    public void saveFromApiTest()
    {
        String jsonFromApi = "[{\"_id\":\"5c6da0e6d8fcaa00040ce956\",\"value\":{\"amount\":5000,\"currency\":\"CZK\"},\"partyAccount\":{\"prefix\":\"47\",\"accountNumber\":\"123456789\",\"bankCode\":\"8080\"},\"dueDate\":\"2019-02-18T16:21:17.067Z\",\"recuringPayment\":{\"firstPayment\":\"2019-02-18T16:21:17.067Z\",\"lastPayment\":\"2019-02-18T16:21:17.067Z\",\"interval\":\"WEEK\"},\"additionalInfo\":{\"constantSymbol\":\"8080\",\"variableSymbol\":\"861225\",\"specificSymbol\":\"8\"},\"accountId\":9876,\"editableByUser\":true,\"realizationStatus\":\"RTS_EDITED\"},{\"_id\":\"5c6da289d8fcaa00040ce957\",\"value\":{\"amount\":5000,\"currency\":\"CZK\"},\"partyAccount\":{\"prefix\":\"47\",\"accountNumber\":\"123456789\",\"bankCode\":\"8080\"},\"dueDate\":\"2019-02-18T16:21:17.067Z\",\"recuringPayment\":{\"firstPayment\":\"2019-02-18T16:21:17.067Z\",\"lastPayment\":\"2019-02-18T16:21:17.067Z\",\"interval\":\"WEEK\"},\"additionalInfo\":{\"constantSymbol\":\"8080\",\"variableSymbol\":\"861225\",\"specificSymbol\":\"8\"},\"accountId\":9876,\"editableByUser\":true,\"realizationStatus\":\"RTS_EDITED\"},{\"_id\":\"5c756f1f79637c00049e6920\",\"value\":{\"amount\":5000,\"currency\":\"CZK\"},\"partyAccount\":{\"prefix\":\"47\",\"accountNumber\":\"123456789\",\"bankCode\":\"8080\"},\"dueDate\":\"2019-02-18T16:21:17.067Z\",\"recuringPayment\":{\"firstPayment\":\"2019-02-18T16:21:17.067Z\",\"lastPayment\":\"2019-02-18T16:21:17.067Z\",\"interval\":\"WEEK\"},\"additionalInfo\":{\"constantSymbol\":\"8080\",\"variableSymbol\":\"861225\",\"specificSymbol\":\"8\"},\"accountId\":9876,\"editableByUser\":true,\"realizationStatus\":\"RTS_EDITED\"},{\"_id\":\"5c756f5f79637c00049e6921\",\"value\":{\"amount\":5000,\"currency\":\"CZK\"},\"partyAccount\":{\"prefix\":\"47\",\"accountNumber\":\"123456789\",\"bankCode\":\"8080\"},\"dueDate\":\"2019-02-26T16:21:17.067Z\",\"recuringPayment\":{\"firstPayment\":\"2019-02-18T16:21:17.067Z\",\"lastPayment\":\"2019-02-18T16:21:17.067Z\",\"interval\":\"WEEK\"},\"additionalInfo\":{\"constantSymbol\":\"8080\",\"variableSymbol\":\"861225\",\"specificSymbol\":\"8\"},\"accountId\":9876,\"editableByUser\":true,\"realizationStatus\":\"RTS_EDITED\"}]";
        Payment[] payments = JsonUtilsSafe.fromJson(jsonFromApi, Payment[].class);

        List<Payment> insertedList = paymentDAO.saveAll(ListUtils.toIterable(payments));
        assertNotNull(insertedList);
        assertEquals(4, insertedList.size());

        List<Payment> paymentList = paymentDAO.findAll();
        assertNotNull(paymentList);
        assertEquals(4, paymentList.size());

        for (Payment p : paymentList)
        {
            assertNotNull(p);
            assertNotNull(p.getId());
//            assertNotNull(p.getPayeeMessage());
//            assertNotNull(p.getPayerMessage());
            assertNotNull(p.getAccountId());

            assertNotNull(p.getPartyAccount());
            assertNotNull(p.getPartyAccount().getAccountNumber());
            assertNotNull(p.getPartyAccount().getPrefix());
            assertNotNull(p.getPartyAccount().getBankCode());


            assertNotNull(p.getAdditionalInfo());
            assertNotNull(p.getAdditionalInfo().getConstantSymbol());
            assertNotNull(p.getAdditionalInfo().getSpecificSymbol());
            assertNotNull(p.getAdditionalInfo().getVariableSymbol());

            assertNotNull(p.getDueDate());

            assertNotNull(p.getRealizationStatus());
            assertNotNull(p.getRealizationStatus().getValue());

            assertNotNull(p.getRecuringPayment());
            assertNotNull(p.getRecuringPayment().getFirstPayment());
            assertNotNull(p.getRecuringPayment().getLastPayment());
            assertNotNull(p.getRecuringPayment().getInterval());
            assertNotNull(p.getRecuringPayment().getInterval().getValue());

            assertNotNull(p.getValue());
            assertNotNull(p.getValue().getAmount());
            assertNotNull(p.getValue().getCurrency());
        }

    }

}
