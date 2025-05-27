package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1707
 * 문제 이름: 이분 그래프
 * 풀이 : BFS로 탐색하며 visit에 1과 2를 번갈아 초기화
 * 현재 노드와 연결된 노드가 같은 visit 값으로 초기화되어있다면 이분 그래프가 아님
 */

class Q1707_이분그래프 {

    static int[] visit;
    static List<Integer>[] node;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (test_case-- > 0) {

            // 알고리즘
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visit = new int[V + 1];
            node = new List[V + 1];
            for (int i = 0; i <= V; i++) {
                node[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                node[s].add(e);
                node[e].add(s);
            }

            grouping(V);
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    public static void grouping(int v) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= v; i++) {
            if(visit[i] == 0) {
                q.addLast(i);
                visit[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.removeFirst();

                for(int j = 0; j < node[now].size(); j++) {
                    if(visit[node[now].get(j)] == 0) {
                        q.add(node[now].get(j));
                    }

                    // 현재 노드와 연결된 노드가 같으면 이분 그래프가 아님
                    if(visit[node[now].get(j)] == visit[now]) {
                        sb.append("NO\n");
                        return;
                    }

                    if(visit[now] == 1 && visit[node[now].get(j)] == 0)
                        visit[node[now].get(j)] = 2;
                    else if(visit[now] == 2 && visit[node[now].get(j)] == 0)
                        visit[node[now].get(j)] = 1;
                }
            }
        }

        sb.append("YES\n");
    }

}