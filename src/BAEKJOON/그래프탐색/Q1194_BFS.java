import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1194_BFS {

    // 상태를 저장할 클래스 (x, y 좌표, 거리, 보유한 열쇠 비트마스크)
    static class State {
        int x, y, dist, keys;

        public State(int x, int y, int dist, int keys) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.keys = keys;
        }
    }

    static int N, M;
    static char[][] map;
    // visited[keys][x][y]
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static State start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        // 2^6 = 64. 0 ~ 63까지의 열쇠 조합
        visited = new boolean[64][N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    // 시작점은 빈 공간으로 만들고, 시작 상태를 저장
                    map[i][j] = '.';
                    start = new State(i, j, 0, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<State> q = new ArrayDeque<>();
        q.add(start);
        visited[start.keys][start.x][start.y] = true;

        while (!q.isEmpty()) {
            State current = q.poll();

            // 출구 도착
            if (map[current.x][current.y] == '1') {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 1. 맵 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 2. 벽 체크
                if (map[nx][ny] == '#') continue;

                char nextCell = map[nx][ny];

                // 3. 열쇠인 경우
                if (nextCell >= 'a' && nextCell <= 'f') {
                    // 현재 열쇠 조합에 새로운 열쇠 추가 (OR 연산)
                    int nextKeys = current.keys | (1 << (nextCell - 'a'));
                    if (!visited[nextKeys][nx][ny]) {
                        visited[nextKeys][nx][ny] = true;
                        q.add(new State(nx, ny, current.dist + 1, nextKeys));
                    }
                }
                // 4. 문인 경우
                else if (nextCell >= 'A' && nextCell <= 'F') {
                    // 문에 해당하는 열쇠가 있는지 확인 (AND 연산)
                    boolean hasKey = (current.keys & (1 << (nextCell - 'A'))) != 0;
                    if (hasKey && !visited[current.keys][nx][ny]) {
                        visited[current.keys][nx][ny] = true;
                        q.add(new State(nx, ny, current.dist + 1, current.keys));
                    }
                }
                // 5. 빈 칸('.'), 출구('1') 등 다른 모든 경우
                else {
                    if (!visited[current.keys][nx][ny]) {
                        visited[current.keys][nx][ny] = true;
                        q.add(new State(nx, ny, current.dist + 1, current.keys));
                    }
                }
            }
        }

        // 큐가 비었는데 출구를 못 찾은 경우
        return -1;
    }
}
