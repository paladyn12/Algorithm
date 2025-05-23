import java.io.*;
import java.util.*;

/**
 * 문제 번호: 1260
 * 문제 이름: DFS와 BFS
 * 풀이: DFS, BFS 방식으로 탐색
 */
class Main {

    static TreeSet<Integer>[] gragh;
    static int N;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        gragh = new TreeSet[N + 1];
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            gragh[i] = new TreeSet<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            gragh[s].add(e);
            gragh[e].add(s);
        }

        dfs(V);
        visit = new boolean[N + 1];
        sb.append("\n");
        bfs(V);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i : gragh[start]) {
            if (!visit[i]) {
                dfs(i);
            }
        }

    }

    static void bfs(int start) {
        visit[start] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);

        while (!queue.isEmpty()) {
            Integer cur = queue.pollFirst();
            sb.append(cur).append(" ");

            for (Integer i : gragh[cur]) {
                if (!visit[i]) {
                    visit[i] = true;
                    queue.addLast(i);
                }
            }
        }
    }

}