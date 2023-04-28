import java.util.*;
public class Obst{

public static int optimalBST(int[] freq, int[] keys) {
    int n = freq.length;
    int[][] dp = new int[n+1][n+1];
    
    for (int i = 0; i < n; i++)
        dp[i][i] = freq[i];
    
    for (int L = 2; L <= n; L++) {
        for (int i = 0; i <= n - L; i++) {
            int j = i + L - 1;
            dp[i][j] = Integer.MAX_VALUE;
            int sum = getSum(freq, i, j);
            for (int k = i; k <= j; k++) {
                int val = sum + (k - 1 < i ? 0 : dp[i][k - 1]) + (k + 1 > j ? 0 : dp[k + 1][j]);
                
                if (val < dp[i][j])
                    dp[i][j] = val;
                
            }
        }
    }

    // print the resulting OBST
    System.out.println("Optimal BST:");
    printOBST(dp, keys, 0, n-1, 0);
    
    return dp[0][n - 1];
}

private static int getSum(int[] freq, int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++)
        sum += freq[k];
    
    return sum;
}

private static void printOBST(int[][] dp, int[] keys, int i, int j, int level) {
    if (i > j) 
        return;
    
    int rootIndex = findRoot(dp, i, j);

    for (int k = 0; k < level; k++) 
        System.out.print("\t");
    
    System.out.println(keys[rootIndex]);
    if (rootIndex + 1 <= j)
        printOBST(dp, keys, rootIndex + 1, j, level + 1);
    
    if (i <= rootIndex - 1)
        printOBST(dp, keys, i, rootIndex - 1, level + 1);
}


private static int findRoot(int[][] dp, int i, int j) {
    int rootIndex = i;
    int minCost = Integer.MAX_VALUE;
    for (int k = i+1; k < j; k++) {
        if (dp[i][k - 1] + dp[k + 1][j] < minCost) {
            rootIndex = k;
            minCost = dp[i][k - 1] + dp[k + 1][j];
        }
    }
    return rootIndex;
}

public static void main(String[] args) {
    System.out.println("Enter the number of keys: ");
    Scanner key = new Scanner(System.in);

    int n = key.nextInt();
    int[] keys = new int [n];
    int[] freq = new int [n];
    System.out.println("Enter the keys: ");
    for (int i = 0; i < n; i++)
        keys[i] = key.nextInt();

    System.out.println("Enter the frequencies: ");
    for (int i = 0; i < n; i++)
        freq[i] = key.nextInt();

    int cost = optimalBST(freq, keys);

    System.out.println("Minimum cost: " + cost);

    key.close();
    }
}
