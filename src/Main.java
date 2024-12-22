import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11053
 * 문제 이름: 가장 긴 증가하는 부분 수열
 * 풀이: dp[i]를 1로 초기화 (최소한 자기 자신만 있는 수열은 가능)
 * 수열에서 이전 index를 살피며 값이 증가했고 dp값이 더 크다면 dp 초기화
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}