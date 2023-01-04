package core;

public class PaymentDocument {
    private String number;
    private long amount;
    private PaymentType type;
    private String contractNumber;
    private String date;

    public PaymentDocument(String number, long amount, PaymentType type, String contractNumber, String date) {
        this.number = number;
        this.amount = amount;
        this.type = type;
        this.contractNumber = contractNumber;
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }
}
