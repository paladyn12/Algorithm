import java.io.*;
import java.util.*;


public class Q17135_시뮬레이션 {

    static int N, M, D;
    static int[][] map;
    static int ans = 0;
    static int[] archers;

    // BFS 탐색 방향 (좌, 상, 우)
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        archers = new int[3];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pick(0, 0);

        System.out.println(ans);
    }

    // 궁수 뽑기, 다 뽑으면 게임 실행
    static void pick(int start, int depth) {
        if (depth == 3) {
            ans = Math.max(ans, game());
            return;
        }
        for (int i = start; i < M; i++) {
            archers[depth] = i;
            pick(i + 1, depth + 1);
        }
    }

    // 게임 시작, 적을 내리지 않고 궁수를 한 칸씩 올려 계산
    static int game() {
        int count = 0;
        int[][] status = new int[N][M];

        for (int line = N; line > 0; line--) {
            for (int archer : archers) {
                for (int d = 1; d <= D; d++) {
                    int cnt = attack(status, d, line, archer);
                    if (cnt < 0) continue;
                    count += cnt;
                    break;
                }
            }
        }

        return count;
    }

    // 거리 별 공격 가능 체크, 처치 가능 적이면 1, 이미 처치한 적이면 0, 탐색이 끝나면 -1
    static int attack(int[][] status, int d, int line, int archer) {
        for (int ny = archer - d; ny <= archer + d; ny++) {
            int nx = line - (d - Math.abs(ny - archer));
            if (nx < 0 || nx >= line || ny < 0 || ny >= M) continue;
            if (map[nx][ny] == 0) continue;
            if (status[nx][ny] == 0) {
                status[nx][ny] = line;
                return 1;
            } else if (status[nx][ny] == line) return 0;
        }
        return -1;
    }
}
