import java.util.*;
import java.io.*;

class Q3289 {

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
            sb.append("#").append(test_case).append(" ");
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                a = find(a);
                b = find(b);

                if (oper == 0) {
                    if (a != b) {
                        parent[b] = a;
                    }
                } else {
                    if (a == b) sb.append(1);
                    else sb.append(0);
                }
            }
            
			sb.append("\n");
		}
        System.out.print(sb);
    }
    
    static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}
