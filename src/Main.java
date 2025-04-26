import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    static int N;
    static int M;
    static int V;
    static int[][] adj;
    static boolean[] visit;
    static ArrayList<Integer> track;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        dfs(V);
        visit = new boolean[N + 1];
        bfs(V);


        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int start) {
        track = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(start);
        while (!stack.isEmpty()) {

            int current = stack.removeLast();
            if (!visit[current]) {
                visit[current] = true;
                track.add(current);
            }
            for (int i = N; i > 0; i--) {
                if (!visit[i] && adj[current][i] == 1) {
                    stack.addLast(i);
                }
            }
        }
        for (Integer i : track) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }

    static void bfs(int start) {
        track = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        while (!queue.isEmpty()) {

            int current = queue.removeFirst();
            if (!visit[current]) {
                visit[current] = true;
                track.add(current);
            }
            for (int i = 1; i <= N; i++) {
                if (!visit[i] && adj[current][i] == 1) {
                    queue.addLast(i);
                }
            }
        }
        for (Integer i : track) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
}