package BAEKJOON.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 1463
 * 문제 이름: 1로 만들기
 * 풀이: X를 3으로 나누는 경우와 2로 나누는 경우를 비교
 */
class Q1463_다이나믹프로그래밍 {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        array[0] = 0;
        array[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (i % 6 == 0) {
                array[i] = Math.min(array[i-1], Math.min(array[i/3], array[i/2])) + 1;
            } else if (i % 3 == 0) {
                array[i] = Math.min(array[i/3], array[i-1]) + 1;
            } else if (i % 2 == 0) {
                array[i] = Math.min(array[i/2], array[i-1]) + 1;
            } else array[i] = array[i-1] + 1;
        }

        System.out.println(array[N]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}