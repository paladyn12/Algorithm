package BAEKJOON.탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 6603
 * 문제 이름: 로또
 * 풀이: dfs 방식으로 모든 경우의 수 출력
 */
class Q6603_DFS {

    static int k;
    static int[] array;
    static boolean[] visit;
    static int[] cur;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            array = new int[k];
            visit = new boolean[k];
            cur = new int[6];
            for (int i = 0; i < k; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();

    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i : cur) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cur[depth] = array[i];
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}