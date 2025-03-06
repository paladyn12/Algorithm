import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            // dp[i]를 구하는 단계
            // j를 i-1부터 0까지 돌리면서 array[j]가 array[i]보다 작을 때 dp를 초기화
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) max = dp[i];
        }

        sb.append(max).append("\n");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = n-1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.addLast(array[i]);
                max--;
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pollLast()).append(" ");

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}