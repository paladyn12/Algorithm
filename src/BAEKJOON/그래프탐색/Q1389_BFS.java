import java.util.*;
import java.io.*;

class Q1389_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        ArrayDeque<Integer> dq;
        int[] visit;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            dq = new ArrayDeque<>();
            dq.addLast(i);
            visit = new int[N + 1];
            Arrays.fill(visit, -1);
            visit[i] = 0;
            int cnt = 0;
            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();
                for (int j = 0; j < graph.get(cur).size(); j++) {
                    int next = graph.get(cur).get(j);
                    if (visit[next] == -1) {
                        visit[next] = visit[cur] + 1;
                        cnt += visit[cur] + 1;
                        dq.addLast(next);
                    }
                }
            }
            if (min > cnt) {
                min = cnt;
                ans = i;
            }
        }
        System.out.print(ans);
    }
}
