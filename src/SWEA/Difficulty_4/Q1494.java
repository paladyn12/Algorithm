import java.io.*;
import java.util.*;

public class Q1494 {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int N;
    static long ans;
    static boolean[] visit;
    static Node[] nodes;

    static int[] p;
    static int[] m;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = Long.MAX_VALUE;
            
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x, y);
            }
            
            visit = new boolean[N];
            p = new int[N / 2];
            m = new int[N / 2];
            dfs(0, 0, 0);
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb);
    }

    static void dfs(int depth, int pCnt, int mCnt) {
        if (depth == N) {
            int px = 0;
            int py = 0;
            int mx = 0;
            int my = 0;

            int pIdx = 0;
            for (int i = 0; i < N; i++) {
                if (pIdx < N / 2 && p[pIdx] == i) {
                    px += nodes[i].x;
                    py += nodes[i].y;
                    pIdx++;
                } else {
                    mx += nodes[i].x;
                    my += nodes[i].y;
                }
            }
            ans = Math.min(ans, ((long)px - mx) * (px - mx) + ((long)py - my) * (py - my));
            return;
        }
        if (pCnt < N / 2) {
            p[pCnt] = depth;
            dfs(depth + 1, pCnt + 1, mCnt);
        }
        if (mCnt < N / 2) {
            m[mCnt] = depth;
            dfs(depth + 1, pCnt, mCnt + 1);
        }
    }

}
