package BAEKJOON.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 14500
 * 문제 이름: 테트로미노
 * 풀이: 가능한 모든 테트로미노의 합을 계산
 */
class Q14500_브루트포스 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, logic(paper, i, j));
            }
        }

        System.out.println(result);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    public static int logic(int[][] paper, int i, int j) {

        int max = Integer.MIN_VALUE;
        if (j+3 < M) max = Math.max(max, paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i][j+3]);
        if (i+3 < N) max = Math.max(max, paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+3][j]);
        if (j + 1 < M && i+1 < N) max = Math.max(max, paper[i][j] + paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1]);

        if (j + 2 < M && i + 1 < N) max = Math.max(max, subLogic1(paper, i, j));
        if (j + 1 < M && i + 2 < N) max = Math.max(max, subLogic2(paper, i, j));

        return max;

    }

    private static int subLogic1(int[][] paper, int i, int j) {

        int max = Integer.MIN_VALUE;

        max = Math.max(max, paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2]);
        max = Math.max(max, paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+1]);
        max = Math.max(max, paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j]);

        max = Math.max(max, paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2] + paper[i][j+2]);
        max = Math.max(max, paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2] + paper[i][j+1]);
        max = Math.max(max, paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2] + paper[i][j]);

        max = Math.max(max, paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2]);
        max = Math.max(max, paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i][j+2]);

        return max;
    }

    private static int subLogic2(int[][] paper, int i, int j) {

        int max = Integer.MIN_VALUE;

        max = Math.max(max, paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j+1]);
        max = Math.max(max, paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j+1]);
        max = Math.max(max, paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i][j+1]);

        max = Math.max(max, paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1] + paper[i+2][j]);
        max = Math.max(max, paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1] + paper[i+1][j]);
        max = Math.max(max, paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1] + paper[i][j]);

        max = Math.max(max, paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j+1]);
        max = Math.max(max, paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j]);

        return max;
    }
}