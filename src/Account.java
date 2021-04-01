import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Account {
    private final String ACCOUNT_ID;
    private final String CARD_NUMBER;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Subscriber subscriber;


    public Account() {
        this.ACCOUNT_ID = UUID.randomUUID().toString();
        this.balance = 0;
        this.CARD_NUMBER = generateCardNumber();
    }

    public String getAccountID() {
        return this.ACCOUNT_ID;
    }

    public String getCardNumber() {
        return this.CARD_NUMBER;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Subscriber getSubscriber() {
        return this.subscriber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        Deposit deposit = new Deposit(this, amount);
        this.balance += amount;
    }

    public void withdraw(double amount, String purpose) {
        Withdrawal withdrawal = new Withdrawal(this, amount, purpose);
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }


    public String generateCardNumber() {
        String cardNumber = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            cardNumber += random.nextInt((9999 - 999) + 1) + " ";
        }
        return cardNumber;
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getPurpose() + " amount: " + transaction.getAmount());
        }
    }

    public void printDeposits() {
        for (Transaction transaction : transactions) {
            if (transaction instanceof Deposit) {
                System.out.println(transaction.getPurpose() + " amount: " + transaction.getAmount());
            }
        }
    }

    public void printWithdrawals() {
        for (Transaction transaction : transactions) {
            if (transaction instanceof Withdrawal) {
                System.out.println(transaction.getPurpose() + " amount: " + transaction.getAmount());
            }
        }
    }

    @Override
    public String toString() {
        return "AccountID: " + this.ACCOUNT_ID + "\n" +
                "Account Holder: " + this.subscriber.getFullName() + "\n" +
                "Card Number: " + this.CARD_NUMBER + "\n" +
                "Balance: " + this.balance;
    }

}
