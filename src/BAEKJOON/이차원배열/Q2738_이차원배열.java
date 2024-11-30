package BAEKJOON.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2738
 * 문제 이름: 행렬 덧셈
 * 문제 링크: https://www.acmicpc.net/problem/2738
 * 풀이: 각 행렬의 값을 더할 이차원 배열을 생성
 */
class Q2738_이차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                result[i][j] = Integer.parseInt(st.nextToken()) + result[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] ints : result) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}