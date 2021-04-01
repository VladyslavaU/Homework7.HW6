import java.util.*;

public class TrafficRecord implements Record {

    private double duration;
    private final Subscriber USER;
    private static final double PRICE = 0.01;
    private static final String PURPOSE = "Traffic Usage | withdrawal";
    private static HashMap<Subscriber, Double> listOfRecords = new HashMap<>();


    TrafficRecord(Subscriber user, double duration) {
        this.duration = duration;
        this.USER = user;
    }

    public void record() {
        if (this.USER.getBalance() < this.cost()) {
            this.duration = this.USER.getBalance() / PRICE;
        }
        this.USER.addTrafficVolume(this.duration);
        this.USER.getAccount().withdraw(this.cost(), PURPOSE);
        listOfRecords.put(this.USER, this.USER.getTrafficVolume());
    }


    public double cost() {
        return this.duration * PRICE;
    }

    public static void printSubscribersByUsage(double duration) {
        for (Map.Entry record : listOfRecords.entrySet()) {
            if ((double) record.getValue() > duration) {
                System.out.println(
                        ((Subscriber) record.getKey()).getFullName() + " : " +
                                ((Subscriber) record.getKey()).getTrafficVolume() + " min in total"
                );
            }
        }
    }

    public static void printSubscribers() {
        for (Map.Entry record : listOfRecords.entrySet()) {
            System.out.println(((Subscriber) record.getKey()).getFullName());
        }
    }

    public static void printTenHeaviestUsers() {
        List<Double> durations = new ArrayList<>(listOfRecords.values());
        durations.sort(Collections.reverseOrder());
        int max = durations.size();
        if (durations.size() > 10) {
            max = 10;
        }
        for (int i = 0; i < max; ++i) {
            System.out.print(i + 1 + " ");

            for (Map.Entry record : listOfRecords.entrySet()) {
                if (record.getValue().equals(durations.get(i))) {
                    System.out.println(" " + ((Subscriber) record.getKey()).getFullName() + " " + durations.get(i) + " megabytes in total");
                }
            }
        }
    }

    public String toString() {
        return "Traffic Volume Used: " + this.duration + "\n" +
                "User Name: " + this.USER.getFullName() + "\n" +
                "Price per minute: $" + PRICE + "\n" +
                "Total cost: $" + this.cost();
    }
}


