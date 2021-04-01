import java.util.UUID;

public class Transaction {

    private String transactionID;
    private String purpose;
    private double amount;

    public Transaction() {
        this.transactionID = UUID.randomUUID().toString();
    }

    public void setTransactionID() {
        this.transactionID = UUID.randomUUID().toString();
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "TransactionID: " + this.getTransactionID() + "\n" +
                "Type: " + this.purpose + "\n" +
                "Amount: " + this.amount + "\n";
    }
}
