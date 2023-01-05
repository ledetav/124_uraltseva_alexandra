package core;

import java.util.HashMap;
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
}
