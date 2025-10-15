import java.io.*;
import java.util.*;

public class Q15681_트리 {

    static int[] cnt;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());
        boolean[] visit = new boolean[N + 1];
        visit[R] = true;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(R);
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int next : graph.get(cur)) {
                if (!visit[next]) {
                    visit[next] = true;
                    tree.get(cur).add(next);
                    dq.addLast(next);
                }
            }
        }

        cnt = new int[N + 1];
        find(R);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            sb.append(cnt[U]).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int n) {
        if (cnt[n] != 0) return cnt[n];
        if (tree.get(n).size() == 0) {
            cnt[n] = 1;
            return 1;
        } else {
            int count = 1;
            for (int next : tree.get(n)) {
                count += find(next);
            }
            cnt[n] = count;
            return cnt[n];
        }
    }
}
