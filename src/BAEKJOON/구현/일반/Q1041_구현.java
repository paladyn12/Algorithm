package BAEKJOON.구현.일반;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1041
 * 문제 이름: 주사위
 * 풀이: 겉에 비춰지는 표면의 수 별로 각각 몇 개의 주사위가 있는지 파악
 */
class Q1041_구현 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        long N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        int oneSurface = Arrays.stream(dice).min().getAsInt();
        int[][] twoAdj = {
                {0,1}, {0,2}, {0,3}, {0,4},
                {5,1}, {5,2}, {5,3}, {5,4},
                {1,2}, {2,4}, {3,4}, {1,3}
        };

        int twoSurface = Integer.MAX_VALUE;
        for (int[] ints : twoAdj) {
            twoSurface = Math.min(twoSurface, dice[ints[0]] + dice[ints[1]]);
        }

        int[][] threeAdj = {
                {0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4},
                {5, 1, 2}, {5, 1, 3}, {5, 2, 4}, {5, 3, 4}
        };
        int threeSurface = Integer.MAX_VALUE;
        for (int[] ints : threeAdj) {
            threeSurface = Math.min(threeSurface, dice[ints[0]] + dice[ints[1]] + dice[ints[2]]);
        }

        int fiveSurface = Arrays.stream(dice).sum();
        fiveSurface -= Arrays.stream(dice).max().getAsInt();

        long result = 0;
        if (N == 1) {
            result += fiveSurface;
        }
        else {
            long one = (N - 2) * (N - 2) * 5 + (N - 2) * 4;
            long two = (N - 1) * 4 + (N - 2) * 4;
            long three = 4L;

            result += one * oneSurface;
            result += two * twoSurface;
            result += three * threeSurface;
        }

        System.out.println(result);

        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}