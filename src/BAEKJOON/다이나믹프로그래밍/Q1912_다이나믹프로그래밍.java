package BAEKJOON.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1912
 * 문제 이름: 연속합
 * 풀이: dp를 array로 우선 초기화한 후 dp[i] 값을 dp[i-1] + array[i]와 dp[i]를 비교
 */
class Q1912_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(array[i], dp[i-1] + array[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            if (i > max) max = i;
        }

        System.out.println(max);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}