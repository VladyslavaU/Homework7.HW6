import java.util.UUID;

public class Withdrawal extends Transaction {
    private final Account ACCOUNT;

    public Withdrawal(Account account, double amount, String purpose) {
        super.setAmount(amount);
        this.ACCOUNT = account;
        super.setPurpose(purpose);
        super.setTransactionID();
        account.addTransaction(this);

    }

    public Account getAccount(){
        return this.ACCOUNT;
    }

    public Boolean checkWithdrawal(double amount, Subscriber caller) {
        return amount < caller.getBalance();
    }

    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String toString(){
        return "TransactionID: " + super.getTransactionID() + "\n" +
                "Type: withdrawal" + "\n" +
                "Purpose: " + this.getPurpose() + "\n" +
                "Amount: " + this.getAmount()  + "\n" +
                "AccountID: " + this.getAccount().getAccountID() + "\n" +
                "Account Holder: " + this.getAccount().getSubscriber().getFullName();
    }

}
