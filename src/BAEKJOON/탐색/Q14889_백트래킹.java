package BAEKJOON.탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 14889
 * 문제 이름: 스타트와 링크
 * 풀이: N개 중 N/2를 뽑는 경우마다 각 팀의 점수를 구하고 최소를 구해나감
 */
class Q14889_백트래킹 {

    static int N;
    static boolean[] visit;
    static int[][] S;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        S = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit[0] = true;
        dfs(0, 1);

        System.out.println(result);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int start, int depth) {
        if (depth == N / 2) {
            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] && visit[j]) {
                        startSum += S[i][j] + S[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        linkSum += S[i][j] + S[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(startSum - linkSum));
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

}