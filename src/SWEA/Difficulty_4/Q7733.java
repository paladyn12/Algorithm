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
 
class Q7733 {
     
    static int ans;
    static boolean[][] visit;
    static int[][] cheese;
    static int N;
     
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;
            int maxDay = 0;
 
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];
            cheese = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay, cheese[i][j]);
                }
            }
             
            for (int day = 0; day <= maxDay; day++) {
                setCheese(day);
                 
                int cnt = 0;
                 
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visit[i][j]) {
                            cnt++;
                            bfs(i, j);
                        }
                    }
                }
                 
                ans = Math.max(ans, cnt);
                 
            }
             
             
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
     
    static void setCheese(int day) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = cheese[i][j] <= day ? true : false;
            }
        }
    }
     
    static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(x, y));
        visit[x][y] = true;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dq.addLast(new Node(nx, ny));
                }
            }
        }
    }
}
