package core;

public class PaymentDocument {
    private String number;
    private int amount;
    private PaymentType type;
    private String contractNumber;
    private String date;

    public PaymentDocument(String number, int amount, PaymentType type, String contractNumber, String date) {
        this.number = number;
        this.amount = amount;
        this.type = type;
        this.contractNumber = contractNumber;
        this.date = date;
    }
}
