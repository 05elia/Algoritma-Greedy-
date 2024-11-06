import java.util.Scanner;

public class Greedy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan Koin: ");
        String coinsInput = scan.nextLine();
        System.out.print("Masukkan Uang: ");
        int n = scan.nextInt();

        String[] splitCoinsInput = coinsInput.split(" ");
        int[] coins = new int[splitCoinsInput.length];
        for (int i = 0; i < splitCoinsInput.length; i++) { 
            coins[i] = Integer.parseInt(splitCoinsInput[i]);
        }

        System.out.println("n: " + n);
        printCoins(coins);
        int total = coinChangeGreedy(coins, n);
        System.out.println("Uang $" + n + " dapat ditukar menjadi " + total + " koin ");
    }

    public static int coinChangeGreedy(int[] coins, int n) {
        int total = 0;
        while(n != 0) {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (coins[i] <= n) {
                    n -= coins[i];
                    System.out.println("Pilih koin " + coins[i] + " tersisa " + n);
                    i++;
                    total++;
                }
            }
        }
        return total;
    }

    public static void printCoins(int[] coins) {
        System.out.println("Koin: ");
        for (int coin : coins) {
            System.out.print("$" + coin + ", ");
        }
        System.out.println("\n");
    }
}
