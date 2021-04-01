import java.util.ArrayList;

public class Provider {
    private ArrayList<LocalRecord> localRecords = new ArrayList<LocalRecord>();
    private ArrayList<DistantRecord> distantRecords = new ArrayList<>();
    private ArrayList<TrafficRecord> trafficRecords = new ArrayList<>();
    private ArrayList<Subscriber> subscribers = new ArrayList<>();

    public void addLocalRecord(LocalRecord localRecord){
        this.localRecords.add(localRecord);
    }

    public void addDistantRecord(DistantRecord distantRecord){
        this.distantRecords.add(distantRecord);
    }

    public void addTrafficRecord(TrafficRecord trafficRecord){
        this.trafficRecords.add(trafficRecord);
    }

}
