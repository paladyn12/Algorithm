package BAEKJOON.정렬;

import java.io.*;
/**
 * 문제 번호: 10989
 * 문제 이름: 수 정렬하기 3
 * 문제 링크: https://www.acmicpc.net/problem/10989
 * 풀이: 카운팅 정렬을 통해 가장 작은 수부터 카운팅 갯수만큼 출력
 */
class Q10989_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int[] nums = new int[10001];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}