package vds.api;

public class Transaction {
    private boolean status = false;
    private String transactionId;

    private User user;

    public Transaction(boolean status, String transactionId, User user) {
        this.status = status;
        this.transactionId = transactionId;
        this.user = user;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }
}
