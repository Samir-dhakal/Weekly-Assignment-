
import java.util.ArrayList;

class Asset {
    String name;
    double returnRate;
    double volatility;

    public Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate + "% (vol=" + volatility + ")";
    }
}

public class Problem4 {

    // ================= MERGE SORT (ASC returnRate, STABLE) =================

    public static void mergeSort(ArrayList<Asset> assets, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(assets, left, mid);
            mergeSort(assets, mid + 1, right);

            merge(assets, left, mid, right);
        }
    }

    public static void merge(ArrayList<Asset> assets, int left, int mid, int right) {

        ArrayList<Asset> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            if (assets.get(i).returnRate <= assets.get(j).returnRate) {
                temp.add(assets.get(i));   // keeps stable order
                i++;
            } else {
                temp.add(assets.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(assets.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(assets.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            assets.set(left + k, temp.get(k));
        }
    }

    // ================= QUICK SORT (DESC returnRate + volatility ASC) =================

    public static void quickSort(ArrayList<Asset> assets, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(assets, low, high);

            quickSort(assets, low, pivotIndex - 1);
            quickSort(assets, pivotIndex + 1, high);
        }
    }

    public static int partition(ArrayList<Asset> assets, int low, int high) {

        Asset pivot = assets.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (compare(assets.get(j), pivot) < 0) {

                i++;

                Asset temp = assets.get(i);
                assets.set(i, assets.get(j));
                assets.set(j, temp);
            }
        }

        Asset temp = assets.get(i + 1);
        assets.set(i + 1, assets.get(high));
        assets.set(high, temp);

        return i + 1;
    }

    // comparison for quick sort
    private static int compare(Asset a, Asset b) {

        if (a.returnRate != b.returnRate) {
            return Double.compare(b.returnRate, a.returnRate); // DESC return
        }

        return Double.compare(a.volatility, b.volatility); // ASC volatility
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new Asset("AAPL", 12, 0.20));
        assets.add(new Asset("TSLA", 8, 0.40));
        assets.add(new Asset("GOOG", 15, 0.18));

        System.out.println("Original assets:");
        for (Asset a : assets) {
            System.out.println(a);
        }

        // Merge Sort ASC
        mergeSort(assets, 0, assets.size() - 1);

        System.out.println("\nMerge Sort (ASC return):");
        for (Asset a : assets) {
            System.out.println(a);
        }

        // Quick Sort DESC
        quickSort(assets, 0, assets.size() - 1);

        System.out.println("\nQuick Sort (DESC return + volatility):");
        for (Asset a : assets) {
            System.out.println(a);
        }
    }
}
