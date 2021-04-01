public class Deposit extends Transaction {

    private double amount;
    private final static String PURPOSE = "Deposit";
    private final Account ACCOUNT;

    public Deposit(Account account, double amount) {
        super.setAmount(amount);
        super.setPurpose(PURPOSE);
        super.setTransactionID();
        this.ACCOUNT = account;
        account.addTransaction(this);

    }

    public double getAmount() {
        return super.getAmount();
    }

    public Account getAccount() {
        return this.ACCOUNT;
    }

    @Override
    public String toString() {
        return "TransactionID: " + super.getTransactionID() + "\n" +
                "Type: deposit" + "\n" +
                "Amount: " + this.getAmount() + "\n" +
                "AccountID: " + this.getAccount().getAccountID() + "\n" +
                "Account Holder: " + this.getAccount().getSubscriber().getFullName();
    }
}
