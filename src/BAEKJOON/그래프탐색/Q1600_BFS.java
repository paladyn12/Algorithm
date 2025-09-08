import java.io.*;
import java.util.*;

public class Q1600_BFS {

    static class Node {
        int x;
        int y;
        int horse_count;

        public Node(int x, int y, int horse_count) {
            this.x = x;
            this.y = y;
            this.horse_count = horse_count;
        }
    }

    static int[] dx_monkey = {-1, 0, 1, 0};
    static int[] dy_monkey = {0, 1, 0, -1};
    
    static int[] dx_horse = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy_horse = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        boolean[][] possible = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                possible[i][j] = Integer.parseInt(st.nextToken()) != 1;
            }
        }


        int[][][] distance = new int[H][W][K + 1];
        for (int i = 0; i < H; i++)  for (int j = 0; j < W; j++) Arrays.fill(distance[i][j], -1);
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0, 0, 0));
        distance[0][0][0] = 0;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            if (cur.horse_count < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + dx_horse[d];
                    int ny = cur.y + dy_horse[d];
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                    if (distance[nx][ny][cur.horse_count + 1] == -1 && possible[nx][ny]) {
                        distance[nx][ny][cur.horse_count + 1] = distance[cur.x][cur.y][cur.horse_count] + 1;
                        if (nx == H - 1 && ny == W - 1) {
                            System.out.print(distance[nx][ny][cur.horse_count + 1]);
                            System.exit(0);
                        }
                        dq.addLast(new Node(nx, ny, cur.horse_count + 1));
                    }
                }
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx_monkey[d];
                int ny = cur.y + dy_monkey[d];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                if (distance[nx][ny][cur.horse_count] == -1 && possible[nx][ny]) {
                    distance[nx][ny][cur.horse_count] = distance[cur.x][cur.y][cur.horse_count] + 1;
                    if (nx == H - 1 && ny == W - 1) {
                        System.out.print(distance[nx][ny][cur.horse_count]);
                        System.exit(0);
                    }
                    dq.addLast(new Node(nx, ny, cur.horse_count));
                }
            }
        }

        System.out.print(distance[H - 1][W - 1][0]);
    }
}
