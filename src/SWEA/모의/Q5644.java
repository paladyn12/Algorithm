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

class BC {
    Node point;
    int c;
    int p;
    public BC(int x, int y, int c, int p) {
        this.point = new Node(x, y);
        this.c = c;
        this.p = p;
    }
}

class Q5644 {

    static ArrayList<BC>[][] map;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;

            map = new ArrayList[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }
            
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[M];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            BC[] BCs = new BC[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                BCs[i] = new BC(x - 1, y - 1, c, p);
                bfs(BCs[i]);
            }

            Node currentA = new Node(0, 0);
            Node currentB = new Node(9, 9);

            calc(currentA, currentB);
            
            for (int i = 0; i < M; i++) {
                currentA.x = currentA.x + dx[A[i]];
                currentA.y = currentA.y + dy[A[i]];
                currentB.x = currentB.x + dx[B[i]];
                currentB.y = currentB.y + dy[B[i]];
                calc(currentA, currentB);
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(BC bc) {
        int[][] visit = new int[10][10];
        ArrayDeque<Node> dq = new ArrayDeque<>();
        visit[bc.point.x][bc.point.y] = 1;
        map[bc.point.x][bc.point.y].add(bc);
        dq.addLast(new Node(bc.point.x, bc.point.y));
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 1; d <= 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
                if (visit[nx][ny] == 0) {
                    visit[nx][ny] = visit[cur.x][cur.y] + 1;
                    map[nx][ny].add(bc);
                    if (visit[nx][ny] <= bc.c)
                        dq.addLast(new Node(nx, ny));
                }
            }
        }
    }

    static void calc(Node A, Node B) {
        ArrayList<BC> BC_A = map[A.x][A.y];
        ArrayList<BC> BC_B = map[B.x][B.y];
        int sum = 0;
        if (BC_A.isEmpty() && BC_B.isEmpty()) return;
        else if (BC_A.isEmpty()) {
            for (BC b : BC_B) {
                sum = Math.max(sum, b.p);
            }
        } else if (BC_B.isEmpty()) {
            for (BC a : BC_A) {
                sum = Math.max(sum, a.p);
            }
        } else {
            for (BC a : BC_A) {
                for (BC b : BC_B) {
                    if (a == b) {
                        sum = Math.max(sum, (a.p + b.p) / 2);
                    } else {
                        sum = Math.max(sum, a.p + b.p);
                    }
                }
            }
        }
        ans += sum;
    }
}    
