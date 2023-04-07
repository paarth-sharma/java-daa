import java.util.*;
public class CoinExchange{
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        // Input the total money and the list of coin denominations
        System.out.print("Enter the total money: ");
        int totalMoney = key.nextInt();

        System.out.print("Enter the coin denominations: ");
        int n = key.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) 
            coins[i] = key.nextInt();

        // Solve the fewest coins problem using dynamic programming
        int[] minCoins = new int[totalMoney + 1];
        int[] coinUsed = new int[totalMoney + 1];

        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= totalMoney; j++) {
                if (minCoins[j - coins[i]] != Integer.MAX_VALUE && minCoins[j - coins[i]] + 1 < minCoins[j]) {
                    minCoins[j] = minCoins[j - coins[i]] + 1;
                    coinUsed[j] = i;
                }
            }
        }

        int fewestCoins = minCoins[totalMoney];
        if (fewestCoins == Integer.MAX_VALUE) {
            System.out.println("-1");
        } 
        else {
            System.out.println("Fewest coins needed: " + fewestCoins);

            // Output the specific coins used to make up the sum
            System.out.print("Coins used: ");
            int[] coinsUsed = new int[fewestCoins];
            int idx = fewestCoins - 1;
            int amountLeft = totalMoney;
            while (amountLeft > 0) {
                int coinIndex = coinUsed[amountLeft];
                coinsUsed[idx] = coins[coinIndex];
                amountLeft -= coins[coinIndex];
                idx--;
            }
            for (int i = 0; i < fewestCoins; i++) {
                System.out.print(coinsUsed[i] + " ");
            }
        }
        key.close();
    }
}
