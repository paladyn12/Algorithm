import java.util.*;
import java.io.*;

class Q11403_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                     graph.get(i).add(j);   
                }
            }
        }

        ArrayDeque<Integer> dq;
        boolean[] visit;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            dq = new ArrayDeque<>();
            dq.addLast(i);
            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();
                for (int j = 0; j < graph.get(cur).size(); j++) {
                    int next = graph.get(cur).get(j);
                    if (!visit[next]) {
                        visit[next] = true;
                        dq.addLast(next);
                    }
                }
            }
            for (boolean b : visit) {
                if (b) sb.append("1 ");
                else sb.append("0 ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
