package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 10971
 * 문제 이름: 외판원 순회 2
 * 풀이: dfs 방식으로 모든 방식을 순회하며 최소 순회 비용인 경우를 구해나감
 */
class Q10971_DFS {

    static int N;
    static int[][] W;
    static int cost = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visit = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(i, i, 0, 0);
            visit[i] = false;
        }

        System.out.println(cost);

        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int first, int start, int depth, int sum) {
        if (depth == N - 1) {
            if (W[start][first] != 0)
                cost = Math.min(cost, sum + W[start][first]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (W[start][i] != 0 && !visit[i]) {
                visit[i] = true;
                dfs(first, i, depth + 1, sum + W[start][i]);
                visit[i] = false;
            }
        }
    }
}