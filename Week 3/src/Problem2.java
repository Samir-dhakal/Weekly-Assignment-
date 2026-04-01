
import java.util.ArrayList;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + "(" + riskScore + ", $" + accountBalance + ")";
    }
}

public class Problem2 {

    // Bubble Sort by riskScore ASC
    public static void bubbleSort(Client [] clients) {
        int swaps = 0;

        for (int i = 0; i < clients.length - 1; i++) {
            for (int j = 0; j < clients.length - 1 - i; j++) {

                if (clients[j].riskScore > clients[j+1].riskScore) {

                    Client temp = clients[j];
                    clients[j] =clients[j+1];
                    clients[j+1]= temp;

                    swaps++;
                }
            }
        }

        System.out.println("Bubble Sort swaps: " + swaps);
    }

    // Insertion Sort by riskScore DESC then accountBalance
    public static void insertionSort(Client [] clients) {

        for (int i = 1; i < clients.length; i++) {

            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 && compare(clients[i], key) < 0) {
                clients[j+1]= clients[j];
                j--;
            }

            clients[j+1]=key;
        }
    }

    // Compare for DESC riskScore + accountBalance
    private static int compare(Client a, Client b) {

        if (a.riskScore != b.riskScore) {
            return Integer.compare(a.riskScore, b.riskScore);
        }

        return Double.compare(a.accountBalance, b.accountBalance);
    }

    // Print top N highest risk clients
    public static void printTopRiskClients(Client [] clients, int n) {

        System.out.println("\nTop " + n + " highest risk clients:");

        for (int i = 0; i < Math.min(n, clients.length); i++) {
            System.out.println(clients[i]);
        }
    }

    public static void main(String[] args) {

//

        Client [] clients={new Client("clientC", 10, 2000),new Client("clientA", 20, 5000),new Client("clientB", 50, 3000)};

        System.out.println("Before sorting:");
        for (Client c : clients) {
            System.out.println(c);
        }

        // Bubble Sort ASC
        bubbleSort(clients);

        System.out.println("\nAfter Bubble Sort (ASC risk):");
        for (Client c : clients) {
            System.out.println(c);
        }

        // Insertion Sort DESC
        insertionSort(clients);

        System.out.println("\nAfter Insertion Sort (DESC risk):");
        for (Client c : clients) {
            System.out.println(c);
        }

        // Top risk clients
        printTopRiskClients(clients, 10);
    }
}
