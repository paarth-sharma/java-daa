import java.util.*;
public class LCS {
   public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Enter first string: ");
    String s1 = key.nextLine();
    System.out.println("Enter the second string: ");
    String s2 = key.nextLine();

    int m = s1.length();
    int n = s2.length();

    int dp[][] = new int [m+1][n+1];
    
    for(int i = 1; i<=m; i++){
        for(int j = 1; j<=n; j++){
            if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }

    int len = dp[m][n];
    System.out.println("Length of longest common subsequence: " + len);

    char lcs[] = new char [len];

    int i = m, j=n;

    while(i > 0 && j > 0){
        if(s1.charAt(i - 1) == s2.charAt(j - 1)){
            lcs[len-1] = s1.charAt(i - 1);
            len--;
            i--;
            j--;
        }
        else if (dp[i - 1][j] > dp[i][j - 1])
            i--;
        else
            j--;
    }

    System.out.println("Longest Common Subsequence is: ");
    for(char c: lcs)
        System.out.print(c);

    key.close();
   } 
}
