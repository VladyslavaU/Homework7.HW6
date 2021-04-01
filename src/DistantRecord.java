import java.util.*;

public class DistantRecord implements Record {
    private double duration;
    private final Subscriber CALLER;
    private static final double PRICE = 0.75;
    private static final String PURPOSE = "DistantCall | withdrawal";
    private static HashMap<Subscriber, Double> listOfRecords = new HashMap<>();


    DistantRecord(Subscriber caller, double duration) {
        this.duration = duration;
        this.CALLER = caller;
    }

    public void record() {
        if (this.CALLER.getBalance() < this.cost()) {
            this.duration = this.CALLER.getBalance() / PRICE;
        }
        this.CALLER.addDistantMinutes(this.duration);
        this.CALLER.getAccount().withdraw(this.cost(), PURPOSE);
        listOfRecords.put(this.CALLER, this.CALLER.getDistantMinutes());
    }


    public double cost() {
        return this.duration * PRICE;
    }

    public static void printSubscribersByUsage(double duration) {
        for (Map.Entry record : listOfRecords.entrySet()) {
            if ((double) record.getValue() > duration) {
                System.out.println(
                        ((Subscriber) record.getKey()).getFullName() + " : " +
                                ((Subscriber) record.getKey()).getDistantMinutes() + " min in total"
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
                    System.out.println(" " + ((Subscriber) record.getKey()).getFullName() + " " + durations.get(i) + " min in total");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Distant Call duration: " + this.duration + "\n" +
                "Caller Name: " + this.CALLER.getFullName() + "\n" +
                "Price per minute: $" + PRICE + "\n" +
                "Total cost: $" + this.cost();
    }
}
