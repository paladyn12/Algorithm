package BAEKJOON.자료구조.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 10798
 * 문제 이름: 세로읽기
 * 풀이: char[5][15] 배열을 만들어 ''로 초기화
 * 각 줄의 입력을 받아 char 배열을 채우고 세로로 읽으며 문자열을 더함
 */
class Q10798_이차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        char[][] board = new char[5][15];

        // 각 줄에서 단어를 입력받아 board에 저장
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // board에 저장된 단어를 세로로 조회하는데 값이 비어있으면 null 문자가 들어가므로 이를 패스함
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++)
            for (int i = 0; i < 5; i++) {
                if (board[i][j] != '\0')
                sb.append(board[i][j]);
            }

        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}