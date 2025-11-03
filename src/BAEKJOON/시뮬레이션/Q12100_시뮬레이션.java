import java.util.*;
import java.io.*;

class Q12100_시뮬레이션 {

    static int N;
    static int[][] map;
    static int[][] copy_map;
    static boolean[][] merged;
    static int ans = 0;
    static int[] oper = new int[5];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        copy_map = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, map[i][j]);
            }
        }

        dfs(0);
        
        System.out.println(ans);
    }

    static void dfs(int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copy_map[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < 5; i++) {
                //System.out.print(oper[i] + " ");
                merged = new boolean[N][N];
                logic(oper[i]);
            }
            //System.out.println();
            return;
        }

        for (int i = 0; i < 4; i++) {
            oper[depth] = i;
            dfs(depth + 1);
        }
    }

    // copy_map의 값을 dir 방향으로 미는 로직
    static void logic(int dir) {
        switch (dir) {
            case 0:
                for (int i = 1; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (copy_map[i][j] > 0) {
                            int curx = i;
                            while (true) {
                                int nx = curx - 1;
                                if (nx < 0) break;
                                if (merged[nx][j]) break;
                                if (copy_map[nx][j] == 0) {
                                    copy_map[nx][j] = copy_map[curx][j];
                                    copy_map[curx][j] = 0;
                                    curx = nx;
                                    continue;
                                }
                                if (copy_map[curx][j] == copy_map[nx][j]) {
                                    copy_map[curx][j] = 0;
                                    copy_map[nx][j] *= 2;
                                    ans = Math.max(ans, copy_map[nx][j]);
                                    merged[nx][j] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = N - 2; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {
                        if (copy_map[i][j] > 0) {
                            int curx = i;
                            while (true) {
                                int nx = curx + 1;
                                if (nx > N - 1) break;
                                if (merged[nx][j]) break;
                                if (copy_map[nx][j] == 0) {
                                    copy_map[nx][j] = copy_map[curx][j];
                                    copy_map[curx][j] = 0;
                                    curx = nx;
                                    continue;
                                }
                                if (copy_map[curx][j] == copy_map[nx][j]) {
                                    copy_map[curx][j] = 0;
                                    copy_map[nx][j] *= 2;
                                    ans = Math.max(ans, copy_map[nx][j]);
                                    merged[nx][j] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int j = 1; j < N; j++) {
                    for (int i = 0; i < N; i++) {
                        if (copy_map[i][j] > 0) {
                            int cury = j;
                            while (true) {
                                int ny = cury - 1;
                                if (ny < 0) break;
                                if (merged[i][ny]) break;
                                if (copy_map[i][ny] == 0) {
                                    copy_map[i][ny] = copy_map[i][cury];
                                    copy_map[i][cury] = 0;
                                    cury = ny;
                                    continue;
                                }
                                if (copy_map[i][cury] == copy_map[i][ny]) {
                                    copy_map[i][cury] = 0;
                                    copy_map[i][ny] *= 2;
                                    ans = Math.max(ans, copy_map[i][ny]);
                                    merged[i][ny] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int j = N - 2; j >= 0; j--) {
                    for (int i = 0; i < N; i++) {
                        if (copy_map[i][j] > 0) {
                            int cury = j;
                            while (true) {
                                int ny = cury + 1;
                                if (ny > N - 1) break;
                                if (merged[i][ny]) break;
                                if (copy_map[i][ny] == 0) {
                                    copy_map[i][ny] = copy_map[i][cury];
                                    copy_map[i][cury] = 0;
                                    cury = ny;
                                    continue;
                                }
                                if (copy_map[i][cury] == copy_map[i][ny]) {
                                    copy_map[i][cury] = 0;
                                    copy_map[i][ny] *= 2;
                                    ans = Math.max(ans, copy_map[i][ny]);
                                    merged[i][ny] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}
