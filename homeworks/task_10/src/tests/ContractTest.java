package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Contract;

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
}
