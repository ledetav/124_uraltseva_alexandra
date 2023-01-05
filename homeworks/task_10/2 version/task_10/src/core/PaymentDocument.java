package core;

public class PaymentDocument {
    private int amount;
    private int number;
    private PaymentDocumentType type;
    private String contractNumber;
    private String paymentDate;
    
    public PaymentDocument(int amount, int number, PaymentDocumentType type, String contractNumber, String paymentDate) {
        this.amount = amount;
        this.number = number;
        this.type = type;
        this.contractNumber = contractNumber;
        this.paymentDate = paymentDate;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getNumber() {
        return number;
    }
    
    public PaymentDocumentType getType() {
        return type;
    }
    
    public String getContractNumber() {
        return contractNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }
}
