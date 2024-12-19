package BAEKJOON.정렬;

import java.io.*;

/**
 * 문제 번호: 2751
 * 문제 이름: 수 정렬하기 2
 * 풀이: 수가 중복되지 않으므로 카운팅 정렬 사용
 * [-1,000,000~1,000,000]개의 boolean을 담아 -100만부터 100만까지 true일 때 출력하도록 함
 */
class Q2751_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean[] nums = new boolean[2000001];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[n+1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000001; i++) {
            if (nums[i]) {
                sb.append(i-1000000).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
