import java.io.*;
import java.util.*;

public class Q1509_다이나믹프로그래밍 {

    static char[] input;
    static int N;
    static boolean[][] isPal; // input[j...k]가 팰린드롬인지 여부
    static int[] dp; // input[0...i-1] (길이 i)의 최소 분할 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();
        N = input.length;

        isPal = new boolean[N][N];
        dp = new int[N + 1]; // dp[0]부터 dp[N]까지 사용

        // 1. 팰린드롬 여부 미리 계산
        checkPalindrome();

        // 2. 최소 분할 개수 계산
        for (int i = 1; i <= N; i++) {
            
            dp[i] = dp[i - 1] + 1; // 최소한 직전 값 + 1보다는 작거나 같음

            for (int j = 0; j < i; j++) {
                // j 번째 문자부터 i - 1번째 문자까지 펠린드롬 이면
                if (isPal[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }

    // 팰린드롬 DP 테이블 채우기
    static void checkPalindrome() {
        for (int i = 0; i < N; i++) {
            isPal[i][i] = true; // 길이 1
        }

        for (int i = 0; i < N - 1; i++) {
            if (input[i] == input[i + 1]) {
                isPal[i][i + 1] = true; // 길이 2
            }
        }

        // 길이 3 이상
        for (int len = 3; len <= N; len++) {
            for (int start = 0; start <= N - len; start++) {
                int end = start + len - 1;
                // 양 끝이 같고, 그 안쪽이 팰린드롬이면 true
                if (input[start] == input[end] && isPal[start + 1][end - 1]) {
                    isPal[start][end] = true;
                }
            }
        }
    }
}
