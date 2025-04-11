package BAEKJOON.자료구조.트리;

import java.io.*;
import java.util.*;

/**
 * 문제 번호: 11725
 * 문제 이름: 트리의 부모 찾기
 * 풀이: 각 parentNode마다 연결된 노드를 list에 저장
 * DFS, BFS 방식으로 list의 연결된 노드를 순회하며 방문하지 않았던 노드가 child 노드임을 이용
 * parent 배열을 채워나감
 */
class Q11725_트리 {

    static int N;                       // 노드의 개수
    static List<Integer>[] list;        // 연결 노드 저장 배열 (희소 그래프이므로 리스트 사용)
    static int[] parent;                // 최종 결과 저장 배열
    static boolean[] visited;           // 방문 결과 저장 배열

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        /* N - 1 개 줄의 입력 처리 */
        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        /* dfs or bfs로 트리 구조를 탐색하면서 parent 배열에 값을 입력 한다. */
        // dfs(1);
        bfs(1);

        /* 트리 탐색이 완료 된 이후에는 parent 배열에 부모 노드 값이 담겨 있으므로
         * 합쳐서 문자열로 만들고 반환한다. */
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }



        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int parentNode) {
        visited[parentNode] = true;

        /* 연결 된 노드를 반복 */
        for(int childNode : list[parentNode]) {
            if(!visited[childNode]) {
                // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다.
                parent[childNode] = parentNode;
                // 그 자식 노드를 부모로 하는 자식 노드를 탐색한다.
                dfs(childNode);
            }
        }
    }

    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int parentNode = queue.poll();

            /* 연결 된 노드를 반복 */
            for (int childNode : list[parentNode]) {
                if (!visited[childNode]) {
                    visited[childNode] = true;
                    // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다.
                    parent[childNode] = parentNode;
                    queue.offer(childNode);
                }
            }
        }
    }
}