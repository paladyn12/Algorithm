package BAEKJOON.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2566
 * 문제 이름: 최댓값
 * 문제 링크: https://www.acmicpc.net/problem/2566
 * 풀이: 중첩 조건문으로 최댓값을 찾아 i, j 값을 반환
 */
class Q2566_이차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > max) {
                    max = board[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(maxI+1).append(" ").append(maxJ+1);

        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}