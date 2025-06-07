package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 16947
 * 문제 이름: 서울 지하철 2호선
 * 풀이 : dfs 방식으로 순환선 탐색
 * 순환선으로부터 거리를 bfs 방식으로 탐색
 */

class Q16947_DFS_BFS {

    static int N;
    static ArrayList<Integer>[] nodes;
    static boolean[] isCycle;
    static boolean[] visit;
    static int[] distance;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s].add(e);
            nodes[e].add(s);
        }

        // 순환에 속하는 node 구하기
        isCycle = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            findCycle(i, 1, i);
        }

        // 순환에 속하는 node들의 거리를 0으로 초기화하고 거리를 담을 distance 배열을 만들어
        // bfs 방식으로 채워나감
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            // distance 배열 값이 -1 인 노드는 거리를 초기화
            int current = queue.pollFirst();
            for (int next : nodes[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.addLast(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();

    }

    private static void findCycle(int cur, int cnt, int start) {
        // 방문
        visit[cur] = true;

        for (int next : nodes[cur]) {
            // 다음노드를 방문하지 않았다면
            if (!visit[next]) findCycle(next, cnt + 1, start);
                // 다음노드를 방문했다면
            else if (next == start && cnt >= 3) {
                // 사이클 표시
                distance[next] = 0;
                isCycle[next] = true;
                return;
            }
        }
    }
}