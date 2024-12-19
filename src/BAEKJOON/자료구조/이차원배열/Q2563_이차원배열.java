package BAEKJOON.자료구조.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2563
 * 문제 이름: 색종이
 * 풀이: 이차원 배열을 생성하여 색종이를 올리는 함수인 put() 구현
 */
class Q2563_이차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int[][] paper = new int[100][100];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            put(paper, x, y);
        }

        int count = 0;
        for (int[] ints : paper) {
            for (int anInt : ints) {
                count += anInt;
            }
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static void put(int[][] paper, int x, int y) {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                paper[x+i][y+j] = 1;
            }
    }
}