import java.util.*;
import java.io.*;

class Q9252_다이나믹프로그래밍 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s2.length() + 1][s1.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i-1) == s2.charAt(0)) dp[1][i] = 1;
            else dp[1][i] = dp[1][i-1];
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i-1) == s1.charAt(0)) dp[i][1] = 1;
            else dp[i][1] = dp[i-1][1];
        }
        for (int i = 2; i <= s2.length(); i++) {
            for (int j = 2; j <= s1.length(); j++) {
                if (s1.charAt(j-1) == s2.charAt(i-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        int i = s2.length();
        int j = s1.length();
        StringBuilder ans = new StringBuilder();
        int ansLength = dp[i][j];
        System.out.println(ansLength);
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i-1][j]) i--;
            else if (dp[i][j] == dp[i][j-1]) j--;
            else {
                ans.append(s1.charAt(j-1));
                i--;
                j--;
            }
        }
        System.out.println(ans.reverse());
    }
}
