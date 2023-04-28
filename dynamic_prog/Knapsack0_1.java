public class Knapsack0_1 {
    static int[] knapsack(int[] weights, int[] values, int capacity){
        int n = weights.length;
        int[][] dp = new int[n+1][capacity+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i-1] <= j)
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
                
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        int[] result = new int[n+1];
        int j = capacity;

        for (int i = n; i >= 1; i--) {
            if (dp[i][j] > dp[i-1][j]) {
                result[i] = 1;
                j -= weights[i-1];
            }
        }
        result[0] = capacity - j;
        result[n] = dp[n][capacity];

        boolean[] chosen = new boolean[n];
        j = capacity;
        for (int i = n; i >= 1; i--) {
            if (dp[i][j] > dp[i-1][j]) {
                chosen[i-1] = true;
                j -= weights[i-1];
            }
        }
        System.out.println("Items chosen: ");
        for (int i = 0; i < n; i++)
            if (chosen[i])
                System.out.print(i+1 + " ");            
        System.out.println();
        
        return result;
    }
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        int[] result = knapsack(weights, values, capacity);
        System.out.println("Total weight: " + result[0]);
        System.out.print("Items chosen: ");
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i+1] == 1) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
        System.out.println("Total profit: " + result[result.length-1]);
    }
    
        
    
}
