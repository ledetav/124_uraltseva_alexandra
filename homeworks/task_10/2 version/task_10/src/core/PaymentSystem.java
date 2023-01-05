package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentSystem {
    private Map<String, Contract> contracts;

    public PaymentSystem() {
        this.contracts = new HashMap<>();
    }

    public void addContract(String number, String date) {
        Contract contract = new Contract(number, date);
        contracts.put(number, contract);
    }

    public Contract getContract(String number) {
        return contracts.get(number);
    }

    public void addPaymentDocument(int amount, int number, PaymentDocumentType type, String contractNumber, String paymentDate) {
        PaymentDocument paymentDocument = new PaymentDocument(amount, number, type, contractNumber, paymentDate);
        Contract contract = contracts.get(contractNumber);
        contract.addPaymentDocument(paymentDocument);
    }
    
    public PaymentDocument getPaymentDocument(String coontractNumber, int number) {
        Contract contract = contracts.get(coontractNumber);
        PaymentDocument paymentDocument = contract.getPaymentDocumentByNumber(number);
        if(paymentDocument != null)
            return paymentDocument;
        return null;
    }

    public List<PaymentDocument> getPaymentsByContractNumber(String contractNumber) {
        List<PaymentDocument> payments = new ArrayList<>();

        for (Contract contract : contracts.values()) {
            if (contract.getNumber().equals(contractNumber)) {
                payments.addAll(contract.getPaymentDocuments());
            }
        }

        return null;
    }
}
