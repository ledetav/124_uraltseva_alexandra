package core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Contract {
    private String number;
    private String date;
    private Map<String, PaymentDocument> paymentDocuments;

    public Contract(String number, String date) {
        this.number = number;
        this.date = date;
        this.paymentDocuments = new HashMap<>();
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public void addPaymentDocument(PaymentDocument paymentDocument) {
        paymentDocuments.put(Integer.toString(paymentDocument.getNumber()), paymentDocument);
    }

    public PaymentDocument getPaymentDocumentByNumber(int number) {
        return paymentDocuments.get(Integer.toString(number));
    }

    public Collection<PaymentDocument> getPaymentDocuments() {
        return paymentDocuments.values();
    }
}