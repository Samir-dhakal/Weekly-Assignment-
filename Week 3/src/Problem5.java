
import java.util.Arrays;

public class Problem5 {

    // ================= LINEAR SEARCH =================

    public static void linearSearch(String[] logs, String target) {

        int first = -1;
        int last = -1;
        int comparisons = 0;

        for (int i = 0; i < logs.length; i++) {

            comparisons++;

            if (logs[i].equals(target)) {

                if (first == -1) {
                    first = i;
                }

                last = i;
            }
        }

        System.out.println("Linear Search:");
        if (first == -1) {
            System.out.println("Account not found");
        } else {
            System.out.println("First occurrence index: " + first);
            System.out.println("Last occurrence index: " + last);
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // ================= BINARY SEARCH =================

    public static void binarySearch(String[] logs, String target) {

        int low = 0;
        int high = logs.length - 1;
        int comparisons = 0;
        int index = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            comparisons++;

            int cmp = logs[mid].compareTo(target);

            if (cmp == 0) {
                index = mid;
                break;
            }
            else if (cmp < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if (index == -1) {
            System.out.println("\nBinary Search: Account not found");
            return;
        }

        // count duplicates
        int count = 1;

        int left = index - 1;
        while (left >= 0 && logs[left].equals(target)) {
            count++;
            left--;
        }

        int right = index + 1;
        while (right < logs.length && logs[right].equals(target)) {
            count++;
            right++;
        }

        System.out.println("\nBinary Search:");
        System.out.println("Found at index: " + index);
        System.out.println("Total occurrences: " + count);
        System.out.println("Comparisons: " + comparisons);
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original logs:");
        System.out.println(Arrays.toString(logs));

        // sort logs for binary search
        Arrays.sort(logs);

        System.out.println("\nSorted logs:");
        System.out.println(Arrays.toString(logs));

        String target = "accB";

        linearSearch(logs, target);
        binarySearch(logs, target);
    }
}
