import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Subscriber {

    private final String SUBSCRIBER_ID;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private final Account ACCOUNT;
    private ArrayList<LocalRecord> localRecords = new ArrayList<>();
    private ArrayList<DistantRecord> distantRecords = new ArrayList<>();
    private ArrayList<TrafficRecord> trafficRecords = new ArrayList<>();

    private static ArrayList<String> subscriberNameList = new ArrayList<>();
    public static ArrayList<Subscriber> subscriberList = new ArrayList<>();

    private double localMinutes = 0;
    private double distantMinutes = 0;
    private double trafficVolume = 0;


    public Subscriber(String firstName, String lastName, String patronymic) {
        this.SUBSCRIBER_ID = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.ACCOUNT = new Account();
        this.ACCOUNT.setSubscriber(this);
        subscriberNameList.add(this.getFullName());
        subscriberList.add(this);
    }

    public String getSubscriberID() {
        return this.SUBSCRIBER_ID;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Account getAccount() {
        return this.ACCOUNT;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName + " " + this.patronymic;
    }

    public void addLocalRecord(double duration) {
        LocalRecord record = new LocalRecord(this, duration);
        record.record();
        this.localRecords.add(record);
    }

    public void addTrafficRecord(double duration) {
        TrafficRecord record = new TrafficRecord(this, duration);
        record.record();
        this.trafficRecords.add(record);
    }

    public void addDistantRecord(double duration) {
        DistantRecord record = new DistantRecord(this, duration);
        record.record();
        this.distantRecords.add(record);
    }

    public double getBalance() {
        return this.ACCOUNT.getBalance();
    }

    public void addLocalMinutes(double minutes) {
        this.localMinutes += minutes;
    }

    public void addDistantMinutes(double minutes) {
        this.distantMinutes += minutes;
    }

    public void addTrafficVolume(double volume) {
        this.trafficVolume += volume;
    }

    public double getLocalMinutes() {
        return this.localMinutes;
    }

    public double getDistantMinutes() {
        return this.distantMinutes;
    }

    public double getTrafficVolume() {
        return this.trafficVolume;
    }

    public ArrayList<LocalRecord> getLocalRecords() {
        return this.localRecords;
    }

    public ArrayList<DistantRecord> getDistantRecords() {
        return this.distantRecords;
    }

    public ArrayList<TrafficRecord> getTrafficRecords() {
        return this.trafficRecords;
    }

    public static void printSubscribersInAlphabeticalOrder() {
        Collections.sort(subscriberNameList);
        for (String name : subscriberNameList) {
            System.out.println(name);
        }
    }

    public static ArrayList<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    @Override
    public String toString() {
        return "SubscriberID: " + this.SUBSCRIBER_ID + "\n" +
                "First Name: " + this.firstName + "\n" +
                "Last Name: " + this.lastName + "\n" +
                "Patronymic: " + this.patronymic + "\n" +
                "Address: " + this.address + "\n" +
                "Phone Number: " + this.phoneNumber + "\n" +
                "Account Number: " + this.ACCOUNT.getAccountID() + "\n" +
                "Credit Card Number: " + this.ACCOUNT.getCardNumber() + "\n" +
                "Balance: " + this.ACCOUNT.getBalance() + "\n" +
                "Local Minutes: " + this.localMinutes + "\n" +
                "Distant Minutes: " + this.distantMinutes + "\n" +
                "Traffic Usage: " + this.trafficVolume;
    }

}
