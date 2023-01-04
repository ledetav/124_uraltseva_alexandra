package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Contract;
import core.PaymentDocument;
import core.PaymentType;

public class ContractTest {
    //
    @Test
    public void add_addNewContractWithUniqueNumber() {
        String number = "123456";
        String date = "20210101";
        Contract contract1 = new Contract(number, date);
        assertNotNull(contract1);
        assertEquals(number, contract1.getNumber());
        assertEquals(date, contract1.getDate());

        String number2 = "654321";
        Contract contract2 = new Contract(number2, date);
        assertNotNull(contract2);
        assertEquals(number2, contract2.getNumber());
        assertEquals(date, contract2.getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_addNewContractWithInvalidNumber_emptyString() {
        new Contract("", "20210315");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_addNewContractWithInvalidNumber_nullArgument() {
        new Contract(null, "20210315");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_addNewContractWithInvalidDate_nullArgument() {
        new Contract("123456", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_addNewContractWithInvalidDate_invalidFormet() {
        new Contract("123456", "20210");
    }

    @Test
    public void add_addPaymentDocumentToContract() {
        Contract contract = new Contract("123456", "20221231");
        PaymentDocument paymentDocument = new PaymentDocument("123", 500, PaymentType.BANK_ORDER, "123456", "20220101");
        contract.addPaymentDocument(paymentDocument);
        assertEquals(1, contract.getPaymentDocuments().size());
        assertTrue(contract.getPaymentDocuments().contains(paymentDocument));
    }
}
