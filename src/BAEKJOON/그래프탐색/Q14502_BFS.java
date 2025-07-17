import java.util.*;
import java.io.*;

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Q14502_BFS {

    static int N;
    static int M;
    static boolean[][] visit;
    static int[][] map;
    static ArrayList<Position> virus = new ArrayList<>();
    static int safe = 0;
    static int result = 0;

    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) virus.add(new Position(i, j));
                if (num == 0) safe++;
                map[i][j] = num;
            }
        }

        // 벽을 3개 세움
        safe -= 3;
        
        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue;
            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue;
                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    
                    visit = new boolean[N][M];
                    result = Math.max(result, safe - bfs(i, j, k));
                }
            }
        }

        System.out.print(result);
    }

    // 바이러스가 퍼지는 범위를 반환하는 메서드
    static int bfs (int a, int b, int c) {
        // 입력 받은 위치에 벽 생성
        map[a / M][a % M] = 1;
        map[b / M][b % M] = 1;
        map[c / M][c % M] = 1;

        int count = 0;

        ArrayDeque<Position> queue = new ArrayDeque<>();
        for (Position v : virus) {
            queue.addLast(v);
        }

        while (!queue.isEmpty()) {
            Position cur = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (!visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    count++;
                    queue.addLast(new Position(nx, ny));
                }
            }
        }

        // 세웠던 벽 해제
        map[a / M][a % M] = 0;
        map[b / M][b % M] = 0;
        map[c / M][c % M] = 0;
        
        return count;
    }

    
}