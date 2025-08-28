import java.util.*;
import java.io.*;

class Q5656 {

    static int ans;
    static int N;
    static int W;
    static int H;
    static int[][] map;
    static int[] trace;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Brick {
        int x;
        int y;
        int size;
        public Brick(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            trace = new int[N];
            int brickCnt = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] != 0) brickCnt++;
                }
            }

            dfs(0);
            
            sb.append("#").append(test_case).append(" ").append(brickCnt - ans).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == N) {
            ans = Math.max(ans, simulate());
            return;
        }
        for (int i = 0; i < W; i++) {
            trace[depth] = i;
            dfs(depth + 1);
        }
    }

    static int simulate() {
        int sum = 0;
        int[][] copyMap = new int[H][W];
        for (int i = 0; i < H; i++) 
            for (int j = 0; j < W; j++) copyMap[i][j] = map[i][j];
        
        
        for (int i = 0; i < N; i++) {
            int currentResult = shoot(copyMap, trace[i]);
            if (currentResult == 0) return 0;
            sum += currentResult;
            gravity(copyMap);
        }
        return sum;
    }

    static int shoot(int[][] copyMap, int shootingCol) {
        int cnt = 0;
        
        ArrayDeque<Brick> dq = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            if (copyMap[i][shootingCol] != 0) {
                dq.addLast(new Brick(i, shootingCol, copyMap[i][shootingCol]));
                copyMap[i][shootingCol] = 0;
                cnt++;
                break;
            }
        }
        while (!dq.isEmpty()) {
            Brick cur = dq.pollFirst();
            for (int i = 1; i <= cur.size - 1; i++) {
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d] * i;
                    int ny = cur.y + dy[d] * i;
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if (copyMap[nx][ny] != 0) {
                        dq.addLast(new Brick(nx, ny, copyMap[nx][ny]));
                        copyMap[nx][ny] = 0;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static void gravity(int[][] copyMap) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (copyMap[j][i] != 0) stack.push(copyMap[j][i]);
            }
            for (int j = H - 1; j >= 0; j--) {
                if (!stack.isEmpty()) copyMap[j][i] = stack.pop();
                else copyMap[j][i] = 0;
            }
        }
    }
}
