package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 1676
 * 문제 이름: 팩토리얼 0의 개수
 * 문제 링크: https://www.acmicpc.net/problem/1676
 * 풀이: 5가 곱해지는 개수를 구함
 */
class Q1676_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
        } else {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                int n = i;
                while (n > 0 && n % 5 == 0) {
                    count++;
                    n /= 5;
                }
            }
            System.out.println(count);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}