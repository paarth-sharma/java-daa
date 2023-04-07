import java.util.*;
public class CoinChange {

    static int minCoins(int[] coins, int l, int v){

        int table[] = new int [v+1];
        table[0] = 0;

        for(int i=1; i <=v; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= v; i++){
            // Go through all coins smaller than i
            for (int j = 0; j < l; j++){
                if (coins[j] <= i){
                    int sub_res = table[i - coins[j]];
                        if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                            table[i] = sub_res + 1;
                }
            }
        }

        if(table[v]==Integer.MAX_VALUE)
            return -1;
    
        return table[v];
    }

    static void whatCoin(int []coins, int v){
        
        for(int i=coins.length-1; i>=0; i--){
            int mul = (v % coins[i]);
                for(int j=mul; j>0; j--){
                    if(v >= coins[i] && v>=0){
                        v -= (coins[i]*(j));
                        System.out.print(coins[i]+" ");
                    }
            } 
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter number of coins: ");
        int n = key.nextInt();
        int coins[] = new int [n];

        System.out.println("Enter coins: ");
        for(int i = 0;i<n; i++)
            coins[i] = key.nextInt();

        System.out.println("Enter the sumvalue of coins: ");
        int  ans = key.nextInt();

        System.out.println("The coins used are: ");
        whatCoin(coins, ans);

        System.out.println("Minimum number of coins for sumvalue:");
        System.out.println(minCoins(coins, coins.length, ans) );

        key.close();
    }
}
