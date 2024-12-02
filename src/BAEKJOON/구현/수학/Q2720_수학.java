package BAEKJOON.구현.수학;

import java.io.*;

/**
 * 문제 번호: 2720
 * 문제 이름: 세탁소 사장 동혁
 * 문제 링크: https://www.acmicpc.net/problem/2720
 * 풀이: 주어진 돈을 25, 10, 5, 1로 나눈 값을 반환
 */
class Q2720_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= test_case; i++) {
            int C = Integer.parseInt(br.readLine());
            sb.append(C/25).append(" ");
            C%=25;
            sb.append(C/10).append(" ");
            C%=10;
            sb.append(C/5).append(" ");
            C%=5;
            sb.append(C).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}