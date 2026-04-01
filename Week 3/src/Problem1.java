import java.time.LocalTime;
import java.util.ArrayList;


public class Problem1 {
    public static void bubbleSort(ArrayList<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            for (int j = 0; j < transactions.size() - 1 - i; j++) {
                if (transactions.get(j).fee > transactions.get(j + 1).fee) {
                    Transaction temp = transactions.get(j);
                    transactions.set(j, transactions.get(j + 1));
                    transactions.set(j + 1, temp);

                }
            }
        }
    }

    public static void insertionSort(ArrayList<Transaction> transactions) {
        for (int i = 1; i < transactions.size(); i++) {
            int j = i - 1;
            Transaction temp = transactions.get(i);
            if (temp.fee < transactions.get(j).fee) {
                while (j >= 0 && temp.fee < transactions.get(j).fee) {
                    transactions.set(j + 1, transactions.get(j));
                    j--;
                }
                transactions.set(j + 1, temp);
            }
        }
        return;
    }

    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 12.5, LocalTime.now()));
        transactions.add(new Transaction(2, 11.5, LocalTime.now()));
        transactions.add(new Transaction(3, 10.5, LocalTime.now()));
        if (transactions.size() < 100) {

            System.out.println("before  sorting ");
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }

            bubbleSort(transactions);
            System.out.println("after sorting ");
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }
        } else if ((transactions.size() < 1000)) {

            System.out.println("before  sorting ");
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }

            insertionSort(transactions);
            System.out.println("after sorting ");
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }
        }

    }


}
