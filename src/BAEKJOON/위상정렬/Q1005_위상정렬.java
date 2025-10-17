import java.io.*;
import java.util.*;
public class Q1005_위상정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            int[] rank = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) time[i] = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph.get(s).add(e);
                rank[e]++;
            }

            int goal = Integer.parseInt(br.readLine());

            int[] distance = new int[N + 1];
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (rank[i] == 0) dq.addLast(i);
                distance[i] = time[i];
            }
            
            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();
                if (cur == goal) {
                    sb.append(distance[cur]).append("\n");
                    break;
                }
                for (int next : graph.get(cur)) {
                    distance[next] = Math.max(distance[next], distance[cur] + time[next]);
                    rank[next]--;
                    if (rank[next] == 0) dq.addLast(next);
                }
            }
        }
        System.out.print(sb);
    }
}
