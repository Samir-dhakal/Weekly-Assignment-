
import java.util.Arrays;

public class Problem6 {

    // -------- Linear Search --------
    public static void linearSearch(int[] arr, int target) {

        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            comparisons++;

            if (arr[i] == target) {
                System.out.println("Linear: threshold found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: threshold " + target + " not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // -------- Binary Search Floor & Ceiling --------
    public static void binaryFloorCeiling(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int floor = -1;
        int ceiling = -1;

        int comparisons = 0;

        while (low <= high) {

            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            }

            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search Result:");
        System.out.println("Floor(" + target + ") = " + floor);
        System.out.println("Ceiling(" + target + ") = " + ceiling);
        System.out.println("Comparisons: " + comparisons);
    }

    // -------- Main --------
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        int target = 30;

        System.out.println("Risk bands: " + Arrays.toString(risks));

        // Linear search
        linearSearch(risks, target);

        // Binary search floor/ceiling
        binaryFloorCeiling(risks, target);
    }
}
