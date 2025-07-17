import java.util.*;
import java.io.*;

class Position {
    int x;
    int y;
    int z;
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Q7569_BFS {

    static int M;
    static int N;
    static int H;

    static int[][][] box;
    static boolean[][][] visit;
    static int[] dx = new int[] {-1, 0, 1, 0, 0, 0};
    static int[] dy = new int[] {0, 1, 0, -1, 0, 0};
    static int[] dz = new int[] {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[N][M][H];
        visit = new boolean[N][M][H];

        ArrayDeque<Position> queue = new ArrayDeque<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][h] = num;
                    if (num == 1) {
                        queue.addLast(new Position(i, j, h));
                        visit[i][j][h] = true;
                    }
                }
            }    
        }
        
        // bfs
        while (!queue.isEmpty()) {
            Position cur = queue.pollFirst();
            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                if (nx < 0 || nx >= N ||
                    ny < 0 || ny >= M ||
                    nz < 0 || nz >= H) continue;
                if (box[nx][ny][nz] == 0) {
                    box[nx][ny][nz] = box[cur.x][cur.y][cur.z] + 1;
                    queue.addLast(new Position(nx, ny, nz));
                }
            }
        }
        
        // 최대 값과 0이 있는지 확인
        boolean fail = false;
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (box[i][j][k] == 0) fail = true;
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }

        if (fail) System.out.println(-1);
        else System.out.println(result - 1);
    }
}