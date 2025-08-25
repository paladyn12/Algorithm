import java.util.*;
import java.io.*;

class Q7465 {

    static int[] parent;
    static int N;
    static int M;
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            boolean[] visit = new boolean[N + 1];
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int n = find(i);
                if (!visit[n]) {
                    visit[n] = true;
                    ans++;
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        System.out.print(sb);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}
