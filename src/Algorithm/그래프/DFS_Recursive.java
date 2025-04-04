package Algorithm.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_Recursive {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adj; // 2차원 인접행렬
    static boolean[] visited; // 방문 체크
    static ArrayList<Integer> track = new ArrayList<>(); // 이동 궤적 기록용
    static int V; // 노드의 갯수 (Vertex)
    static int E; // 간선의 갯수 (Edges)

    // 그래프 프린트용
    static void print(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int currentNode) { // 현재 위치의 node에서 dfs 로직 시작!
        // 로직 1
        if (!visited[currentNode]) { // current가 visited에 없다면?
            visited[currentNode] = true; // 방문체크를 해줍니다.
            track.add(currentNode);
        }

        // 로직 2
        // 인접행렬을 하나씩 돌면서! (0번 포도알 없음에 주의)
        for (int destination = 1; destination < V+1; destination++) {
            // 도착 노드가 방문체크되지 않았고 + 갈 수 있다면?
            if (!visited[destination] && adj[currentNode][destination] == 1) {
                dfs(destination); // 다음 노드로 재귀 진행!
            }
        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new int[V+1][V+1]; // 인덱스 - 노드번호 매칭 위해서 1칸 넉넉하게
        visited = new boolean[V+1];

        // 인접행렬 완성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start][end] = 1;
            adj[end][start] = 1;
        }

        // 1번 포도알부터 dfs 시작!
        dfs(1);

        // 궤적을 기록해봅니다.
        System.out.println(track); // [1, 2, 4, 6, 5, 7, 3]
        System.out.println(track.size()); // 7 => 이어져있는 노드들의 집합 갯수
    }
}