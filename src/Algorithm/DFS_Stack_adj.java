package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS_Stack_adj {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static boolean[] visited;
    static int startNode = 1;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> tracks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V+1];

        adj = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }

//        System.out.println(Arrays.toString(adj));

        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(startNode));

        while (!stack.isEmpty()) {
            int cur = stack.removeLast();
            if (!visited[cur]) {
                visited[cur] = true;
                tracks.add(cur);
            }

            for (Integer destination : adj[cur]) {
                if (!visited[destination]) {
                    stack.addLast(destination);
                }
            }
        }

        System.out.println(tracks);

    }
}