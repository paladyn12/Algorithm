import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q2573_BFS {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n > 0) cnt++;
            }
        }

        int year = 0;

        ArrayDeque<Node> dq;

        while (true) {
            if (cnt == 0) {
                year = 0;
                break;
            }
            int currentCnt = 0;
            int[][] melt = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(melt[i], -1);
            }
            
            dq = new ArrayDeque<>();
            boolean didBfs = false;
            
            for (int i = 0; i < N; i++) {
                if (didBfs) break;
                for (int j = 0; j < M; j++) {
                    if (didBfs) break;
                    if (map[i][j] > 0) {
                        didBfs = true;
                        dq.addLast(new Node(i, j));
                        melt[i][j] = calcMelt(i, j);
                        currentCnt++;
                        
                        while (!dq.isEmpty()) {
                            Node cur = dq.pollFirst();
                            for (int d = 0; d < 4; d++) {
                                int nx = cur.x + dx[d];
                                int ny = cur.y + dy[d];
                                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                                if (map[nx][ny] > 0 && melt[nx][ny] == -1) {
                                    currentCnt++;
                                    melt[nx][ny] = calcMelt(nx, ny);
                                    dq.addLast(new Node(nx, ny));
                                }
                            }
                        }
                    }
                }
            }

            if (currentCnt != cnt) break;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (melt[i][j] != -1) {
                        map[i][j] -= melt[i][j];
                        if (map[i][j] <= 0) {
                            map[i][j] = 0;
                            cnt--;
                        } 
                    }
                }
            }
            year++;
        }
        
        System.out.print(year);
	}

    static int calcMelt(int x, int y) {
        int sum = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (map[nx][ny] == 0) sum++;
        }
        return sum;
    }
}
