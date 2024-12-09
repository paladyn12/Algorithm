package BAEKJOON.자료구조.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 5597
 * 문제 이름: 과제 안 내신 분..?
 * 문제 링크: https://www.acmicpc.net/problem/5597
 * 풀이: int[30]의 배열을 만들고 이름이 불리면 해당 index++, 최종적으로 0인 값의 index가 답
 */
class Q5597_일차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int[] students = new int[31];

        for (int i = 0; i < 28; i++) {
            students[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 1; i < 31; i++) {
            if (students[i] == 0) {
                System.out.println(i);
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}