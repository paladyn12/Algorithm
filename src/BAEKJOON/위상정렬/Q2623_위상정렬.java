import java.io.*;
import java.util.*;

public class Q2623_위상정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] rank = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int m = 0; m < M; m++) {
            int prev = 0;
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            for (int i = 0; i < number; i++) {
                int next = Integer.parseInt(st.nextToken());
                if (prev == 0) prev = next;
                else {
                    graph.get(prev).add(next);
                    rank[next]++;
                    prev = next;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean[] visit = new boolean[N + 1];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (rank[i] == 0) {
                pq.offer(i);
                visit[i] = true;
                sb.append(i).append("\n");
            }
            
        }
        
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int next : graph.get(cur)) {
                rank[next]--;
                if (rank[next] == 0 && !visit[next]) {
                    pq.offer(next);
                    visit[next] = true;
                    sb.append(next).append("\n");
                }
            }
        }

        boolean success = true;
        for (int i = 1; i <= N; i++) if (!visit[i]) success = false;
        if (!success) System.out.print(0);
        else System.out.print(sb);
    }
}
