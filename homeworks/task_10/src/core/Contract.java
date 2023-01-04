package core;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    private String number;
    private String date;
    private List<PaymentDocument> paymentDocuments;

    public Contract(String number, String date) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Contract number cannot be null or empty");
        }
        if (date == null || date.trim().length() != 8) {
            throw new IllegalArgumentException("Date must be in YYYYMMDD format");
        }
        this.number = number;
        this.date = date;
        this.paymentDocuments = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public void addPaymentDocument(PaymentDocument paymentDocument) {
        paymentDocuments.add(paymentDocument);
    }

    public List<PaymentDocument> getPaymentDocuments() {
        return paymentDocuments;
    }

    public void removePaymentDocument(PaymentDocument paymentDocument) {
        paymentDocuments.remove(null);
    }
}
