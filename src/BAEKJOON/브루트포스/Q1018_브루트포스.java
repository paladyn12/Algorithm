package BAEKJOON.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1018
 * 문제 이름: 체스판 다시 칠하기
 * 풀이: i : 0~M-8, j : 0~N-8 에 대해 칠해야 하는 정사각형 최솟값
 */
class Q1018_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                min = Math.min(min, logic(board, i, j));
            }
        }
        System.out.println(min);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
    private static int logic(char[][] board, int x, int y) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j)%2==0) {
                    if (board[i+x][j+y] == 'B') sumA++;
                } else {
                    if (board[i+x][j+y] == 'W') sumA++;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j)%2==0) {
                    if (board[i+x][j+y] == 'W') sumB++;
                } else {
                    if (board[i+x][j+y] == 'B') sumB++;
                }
            }
        }
        return Math.min(sumA, sumB);
    }
}