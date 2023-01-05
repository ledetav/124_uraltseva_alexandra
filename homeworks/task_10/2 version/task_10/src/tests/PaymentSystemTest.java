package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import core.PaymentDocument;
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
        assertNotNull(paymentSystem.getPaymentDocument(contractNumber, number));
        assertEquals(amount, paymentSystem.getPaymentDocument(contractNumber, number).getAmount());
        assertEquals(number, paymentSystem.getPaymentDocument(contractNumber, number).getNumber());
        assertEquals(type, paymentSystem.getPaymentDocument(contractNumber, number).getType());
        assertEquals(contractNumber, paymentSystem.getPaymentDocument(contractNumber, number).getContractNumber());
        assertEquals(paymentDate, paymentSystem.getPaymentDocument(contractNumber, number).getPaymentDate());
    }
    
    @Test
    public void get_getPaymentsByContractNumber() {
        // Создаем экземпляр PaymentSystem
        PaymentSystem paymentSystem = new PaymentSystem();

        // Создаем договоры с разными номерами
        String contractNumber1 = "123456";
        String contractNumber2 = "654321";
        String contractDate = "20221231";
        paymentSystem.addContract(contractNumber1, contractDate);
        paymentSystem.addContract(contractNumber2, contractDate);

        // Создаем платежные документы для каждого договора
        int amount1 = 10000; // 100 рублей
        int number1 = 1;
        PaymentDocumentType type1 = PaymentDocumentType.PAYMENT_ORDER;
        String paymentDate1 = "20220101";
        paymentSystem.addPaymentDocument(amount1, number1, type1, contractNumber1, paymentDate1);

        int amount2 = 20000; // 200 рублей
        int number2 = 2;
        PaymentDocumentType type2 = PaymentDocumentType.BANK_ORDER;
        String paymentDate2 = "20220201";
        paymentSystem.addPaymentDocument(amount2, number2, type2, contractNumber1, paymentDate2);

        int amount3 = 30000; // 300 рублей
        int number3 = 3;
        PaymentDocumentType type3 = PaymentDocumentType.PAYMENT_ORDER;
        String paymentDate3 = "20220301";
        paymentSystem.addPaymentDocument(amount3, number3, type3, contractNumber2, paymentDate3);

        // Проверяем, что метод getPaymentsByContractNumber возвращает список платежей для договора с номером 123456
        List<PaymentDocument> paymentsByContractNumber1 = paymentSystem.getPaymentsByContractNumber(contractNumber1);
        assertEquals(2, paymentsByContractNumber1.size());
        assertEquals(1, paymentsByContractNumber1.get(0).getNumber());
        assertEquals(2, paymentsByContractNumber1.get(1).getNumber());
        assertEquals("123456", paymentsByContractNumber1.get(0).getContractNumber());
        assertEquals("123456", paymentsByContractNumber1.get(1).getContractNumber());
    }
}