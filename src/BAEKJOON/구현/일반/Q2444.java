package BAEKJOON.구현.일반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 2444
 * 문제 이름: 별 찍기 - 7
 * 문제 링크: https://www.acmicpc.net/problem/2444
 * 풀이: 공백 abs(5-i) 별 9-abs(i2-10)
 */
class Q2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 2*N-1; i++) {
            for (int j = 0; j < Math.abs(N-i); j++) {
                sb.append(" ");
            }
            for (int j = 0; j < (2*N-1)-Math.abs(i*2-2*N); j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}
