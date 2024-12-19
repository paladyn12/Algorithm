package BAEKJOON.구현.수학;

import java.io.*;
/**
 * 문제 번호: 11653
 * 문제 이름: 소인수분해
 * 풀이: 2부터 i를 증가시켜 N이 i로 나눠질 때마다 출력
 */
class Q11653_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i*i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        if (N != 1) {
            sb.append(N);
        }
        System.out.print(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}