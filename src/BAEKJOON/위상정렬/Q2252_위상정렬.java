import java.util.*;
import java.io.*;

class Q2252_위상정렬 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] rank = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            rank[b]++;
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) if (rank[i] == 0) dq.addLast(i);

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            sb.append(cur).append(" ");
            for (int next : graph.get(cur)) {
                rank[next]--;
                if (rank[next] == 0) dq.addLast(next);
            }
        }
        System.out.print(sb);
    }
}
