package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.PaymentDocumentType;
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

    @Test
    public void add_addPaymentDocument() {
        // Создаем экземпляр PaymentSystem
        PaymentSystem paymentSystem = new PaymentSystem();

        // Создаем новый договор
        String contractNumber = "123456";
        String contractDate = "20221231";
        paymentSystem.addContract(contractNumber, contractDate);

        // Создаем платежный документ с указанными суммой, номером, типом документа,
        // номером договора и датой платежа
        int amount = 10000; // 100 рублей
        int number = 1;
        PaymentDocumentType type = PaymentDocumentType.PAYMENT_ORDER;
        String paymentDate = "20220101";
        paymentSystem.addPaymentDocument(amount, number, type, contractNumber, paymentDate);

        // Проверяем, что платежный документ успешно добавлен в систему
        assertNotNull(paymentSystem.getPaymentDocument(number));
        assertEquals(amount, paymentSystem.getPaymentDocument(number).getAmount());
        assertEquals(number, paymentSystem.getPaymentDocument(number).getNumber());
        assertEquals(type, paymentSystem.getPaymentDocument(number).getType());
        assertEquals(contractNumber, paymentSystem.getPaymentDocument(number).getContractNumber());
        assertEquals(paymentDate, paymentSystem.getPaymentDocument(number).getPaymentDate());
    }
}