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

class Q10026_BFS {

    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int no = 0;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    no++;
                    bfs(i, j);
                }
            }
        }
        int yes = 0;
        visit = new boolean[N][N];
        // 적록색약은 R과 G를 같게 취급
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    yes++;
                    bfs(i, j);
                }
            }
        }

        System.out.print(no + " " + yes);
    }

    static void bfs(int x, int y) {
        char RGB = map[x][y];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(x, y));
        visit[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] == RGB && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.addLast(new Node(nx, ny));
                }
            }
        }
    }
}