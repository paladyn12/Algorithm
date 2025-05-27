package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2606
 * 문제 이름: 바이러스
 * 풀이: DFS 방식으로 1과 연결된 노드 수를 구함
 */
class Q2606_DFS {

    static int V;
    static int E;
    static int[][] adj;
    static boolean[] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adj = new int[V+1][V+1];
        visit = new boolean[V+1];
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        int startNode = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(startNode));
        visit[1] = true;
        while (!stack.isEmpty()) {

            int current = stack.removeLast();
            if (!visit[current]) {
                visit[current] = true;
                count++;
            }
            for (int i = 1; i <= V; i++) {
                if (!visit[i] && adj[current][i] == 1) {
                    stack.addLast(i);
                }
            }
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}