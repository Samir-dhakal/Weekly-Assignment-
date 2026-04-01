
import java.util.ArrayList;

class Trade {
    String id;
    int volume;

    public Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public String toString() {
        return id + ":" + volume;
    }
}

public class Problem3 {

    // ================= MERGE SORT (ASCENDING) =================

    public static void mergeSort(ArrayList<Trade> trades, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(trades, left, mid);
            mergeSort(trades, mid + 1, right);

            merge(trades, left, mid, right);
        }
    }

    public static void merge(ArrayList<Trade> trades, int left, int mid, int right) {

        ArrayList<Trade> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            if (trades.get(i).volume <= trades.get(j).volume) {
                temp.add(trades.get(i));
                i++;
            } else {
                temp.add(trades.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(trades.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(trades.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            trades.set(left + k, temp.get(k));
        }
    }

    // ================= QUICK SORT (DESCENDING) =================

    public static void quickSort(ArrayList<Trade> trades, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(trades, low, high);

            quickSort(trades, low, pivotIndex - 1);
            quickSort(trades, pivotIndex + 1, high);
        }
    }

    public static int partition(ArrayList<Trade> trades, int low, int high) {

        int pivot = trades.get(high).volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (trades.get(j).volume > pivot) { // DESC order
                i++;

                Trade temp = trades.get(i);
                trades.set(i, trades.get(j));
                trades.set(j, temp);
            }
        }

        Trade temp = trades.get(i + 1);
        trades.set(i + 1, trades.get(high));
        trades.set(high, temp);

        return i + 1;
    }

    // ================= MERGE TWO SORTED LISTS =================

    public static ArrayList<Trade> mergeTwoLists(ArrayList<Trade> a, ArrayList<Trade> b) {

        ArrayList<Trade> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {

            if (a.get(i).volume <= b.get(j).volume) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }

        return result;
    }

    // ================= TOTAL VOLUME =================

    public static int totalVolume(ArrayList<Trade> trades) {

        int sum = 0;

        for (Trade t : trades) {
            sum += t.volume;
        }

        return sum;
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        ArrayList<Trade> trades = new ArrayList<>();

        trades.add(new Trade("trade3", 500));
        trades.add(new Trade("trade1", 100));
        trades.add(new Trade("trade2", 300));

        System.out.println("Original trades:");
        for (Trade t : trades) {
            System.out.println(t);
        }

        // Merge Sort ASC
        mergeSort(trades, 0, trades.size() - 1);

        System.out.println("\nAfter MergeSort (ASC volume):");
        for (Trade t : trades) {
            System.out.println(t);
        }

        // Quick Sort DESC
        quickSort(trades, 0, trades.size() - 1);

        System.out.println("\nAfter QuickSort (DESC volume):");
        for (Trade t : trades) {
            System.out.println(t);
        }

        // Example morning + afternoon merge
        ArrayList<Trade> morning = new ArrayList<>();
        morning.add(new Trade("m1", 200));
        morning.add(new Trade("m2", 400));

        ArrayList<Trade> afternoon = new ArrayList<>();
        afternoon.add(new Trade("a1", 100));
        afternoon.add(new Trade("a2", 300));

        mergeSort(morning, 0, morning.size() - 1);
        mergeSort(afternoon, 0, afternoon.size() - 1);

        ArrayList<Trade> merged = mergeTwoLists(morning, afternoon);

        System.out.println("\nMerged sessions:");
        for (Trade t : merged) {
            System.out.println(t);
        }

        System.out.println("\nTotal volume: " + totalVolume(merged));
    }
}

