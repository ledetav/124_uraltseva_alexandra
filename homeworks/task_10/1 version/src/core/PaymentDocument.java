package core;

public class PaymentDocument {
    private int number;
    private long amount;
    private PaymentType type;
    private String contractNumber;
    private String date;

    public PaymentDocument(int number, long amount, PaymentType type, String contractNumber, String date) {
        this.number = number;
        this.amount = amount;
        this.type = type;
        this.contractNumber = contractNumber;
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }
}
