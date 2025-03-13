package BAEKJOON.브루트포스;

import java.io.*;

/**
 * 문제 번호: 3085
 * 문제 이름: 사탕 게임
 * 풀이: 연속된 가로, 세로의 최대 길이를 구하는 메서드 logic1, logic2를 작성하고
 * 사탕을 바꿨을 경우에 대해 각각의 최대 길이를 구해나감
 */
class Q3085_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // 배열 넣고 연속된 가장 긴 배열 메서드화
        // 사탕을 바꿨을 경우에 대해 메서드 호출
        int N = Integer.parseInt(br.readLine()); // 3 ~ 50
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int result = 0;
        result = Math.max(result, logic1(board, N));
        result = Math.max(result, logic2(board, N));


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (board[i][j] != board[i][j+1]) {
                    char temp = board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = temp;

                    result = Math.max(result, logic1(board, N));
                    result = Math.max(result, logic2(board, N));


                    temp = board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (board[j][i] != board[j+1][i]) {
                    char temp = board[j][i];
                    board[j][i] = board[j+1][i];
                    board[j+1][i] = temp;

                    result = Math.max(result, logic1(board, N));
                    result = Math.max(result, logic2(board, N));

                    temp = board[j][i];
                    board[j][i] = board[j+1][i];
                    board[j+1][i] = temp;

                }
            }
        }

        System.out.println(result);


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    static int logic1(char[][] board, int N) {
        int max = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 0; i < N; i++) {

            char prev = board[i][0];

            for (int j = 1; j < N; j++) {

                if (board[i][j] == prev) {
                    count++;
                }  else {
                    max = Math.max(count, max);
                    count = 1;
                    prev = board[i][j];
                }

                if (j == N-1) {
                    max = Math.max(count, max);
                    count = 1;
                }
            }
        }
        return max;
    }

    static int logic2(char[][] board, int N) {
        int max = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 0; i < N; i++) {

            char prev = board[0][i];

            for (int j = 1; j < N; j++) {

                if (board[j][i] == prev) {
                    count++;
                }  else {
                    max = Math.max(count, max);
                    count = 1;
                    prev = board[j][i];
                }

                if (j == N-1) {
                    max = Math.max(count, max);
                    count = 1;
                }
            }
        }
        return max;
    }
}