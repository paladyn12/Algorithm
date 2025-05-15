package BAEKJOON.구현.수학;

import java.io.*;

/**
 * 문제 번호: 10974
 * 문제 이름: 모든 순열
 * 풀이: DFS 방식으로 모든 순열 탐색
 */
class Q10974_순열 {

    static int[] array;
    static boolean[] visit;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        visit = new boolean[N + 1];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}