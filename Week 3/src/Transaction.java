import java.time.LocalTime;

public class Transaction {
    int tID;
    double fee;
    LocalTime timeStamp;

    public Transaction(int tID, double fee, LocalTime timeStamp) {
        this.fee = fee;
        this.tID = tID;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tID=" + tID +
                ", fee=" + fee +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
