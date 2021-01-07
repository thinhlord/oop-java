package vds.api.model;

import vds.api.Transaction;

public class PaymentProcessor {

    public Transaction process(Transaction trans) {
        trans.setStatus(true);
        return trans;
    }
}
