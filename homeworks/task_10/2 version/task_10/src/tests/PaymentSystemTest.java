package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.PaymentSystem;

public class PaymentSystemTest {
    @Test
    public void add_addContract() {
        // Создаем экземпляр PaymentSystem
        PaymentSystem paymentSystem = new PaymentSystem();

        // Создаем новый договор с указанными номером и датой заключения
        String contractNumber = "123456";
        String contractDate = "20221231";
        paymentSystem.addContract(contractNumber, contractDate);

        // Проверяем, что договор успешно добавлен в систему
        assertNotNull(paymentSystem.getContract(contractNumber));
        assertEquals(contractNumber, paymentSystem.getContract(contractNumber).getNumber());
        assertEquals(contractDate, paymentSystem.getContract(contractNumber).getDate());
    }
}