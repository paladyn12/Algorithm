package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 10872
 * 문제 이름: 팩토리얼
 * 문제 링크: https://www.acmicpc.net/problem/10872
 * 풀이: long 타입으로 팩토리얼 연산
 */
class Q10872_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(1);
        } else {
            long result = 1;
            for (int i = 1; i <= N; i++) {
                result *= i;
            }
            System.out.println(result);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}