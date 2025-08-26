import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Q1247 {

    static int N;
    static boolean[] visit;
    static Node[] customers;
    static Node company;
    static Node home;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            visit = new boolean[N];
            customers = new Node[N];

            st = new StringTokenizer(br.readLine());
            company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < N; i++) {
                customers[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N; i++) {
                visit[i] = true;
                bfs(1, i, Math.abs(company.x - customers[i].x) + Math.abs(company.y - customers[i].y));
                visit[i] = false;
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int depth, int lastIndex, int sum) {
        if (depth == N) {
            ans = Math.min(ans, sum + Math.abs(home.x - customers[lastIndex].x) + Math.abs(home.y - customers[lastIndex].y));
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                bfs(depth + 1, i, sum + Math.abs(customers[lastIndex].x - customers[i].x) + Math.abs(customers[lastIndex].y - customers[i].y));
                visit[i] = false;
            }
        }
    }
}
