package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 14002
 * 문제 이름: 가장 긴 증가하는 부분 수열 4
 * 풀이: 부분 수열을 구하기 위해 stack 사용
 */
class Q14002_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        int value = max;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = N-1; i >= 0; i--) {
            if (dp[i] == value) {
                stack.addLast(nums[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}