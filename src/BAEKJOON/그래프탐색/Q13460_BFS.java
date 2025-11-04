import java.util.*;
import java.io.*;

public class Q13460_BFS {

    static int N, M;
    static char[][] map;
    
    // 방문 여부를 체크할 4차원 배열: [rx][ry][bx][by]
    static boolean[][][][] visited;
    
    // 상, 하, 좌, 우 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 구슬의 위치와 이동 횟수를 저장할 클래스
    static class Node {
        int rx, ry;
        int bx, by;
        int count;

        Node(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.'; // 구슬 위치는 빈 칸으로 변경
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.'; // 구슬 위치는 빈 칸으로 변경
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 10번을 초과하면 탐색 중지 (문제 조건)
            if (current.count >= 10) {
                continue;
            }

            // 4방향(상, 하, 좌, 우)으로 기울이기 시도
            for (int i = 0; i < 4; i++) {
                int nrx = current.rx;
                int nry = current.ry;
                int nbx = current.bx;
                int nby = current.by;
                
                boolean rInHole = false;
                boolean bInHole = false;

                // 1. 파란 구슬 이동 (벽을 만나거나 구멍에 빠질 때까지)
                while (map[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    if (map[nbx][nby] == 'O') {
                        bInHole = true;
                        break;
                    }
                }

                // 2. 빨간 구슬 이동 (벽을 만나거나 구멍에 빠질 때까지)
                while (map[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    if (map[nrx][nry] == 'O') {
                        rInHole = true;
                        break;
                    }
                }

                // 3. 결과 처리
                // 파란 구슬이 구멍에 빠졌다면, 이 경로는 실패 (빨간 구슬이 같이 빠져도 실패)
                if (bInHole) {
                    continue; // 이 방향으로의 탐색은 무시
                }

                // 파란 구슬은 안 빠지고, 빨간 구슬만 빠졌다면 성공
                if (rInHole) {
                    return current.count + 1;
                }

                // 4. 두 구슬이 같은 위치에 겹친 경우 처리
                if (nrx == nbx && nry == nby) {
                    // 이동 방향(i)에 따라 더 "뒤쪽"에 있었던 구슬을 한 칸 뒤로 물립니다.
                    switch (i) {
                        case 0: // 위
                            if (current.rx > current.bx) nrx++; else nbx++;
                            break;
                        case 1: // 아래
                            if (current.rx < current.bx) nrx--; else nbx--;
                            break;
                        case 2: // 왼쪽
                            if (current.ry > current.by) nry++; else nby++;
                            break;
                        case 3: // 오른쪽
                            if (current.ry < current.by) nry--; else nby--;
                            break;
                    }
                }

                // 5. 방문하지 않은 새로운 상태라면 큐에 추가
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.add(new Node(nrx, nry, nbx, nby, current.count + 1));
                }
            }
        }

        // 큐가 비울 때까지 성공하지 못했으면 -1 반환
        return -1;
    }
}
