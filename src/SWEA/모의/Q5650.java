import java.io.*;
import java.util.*;

public class Q5650 {

    static int N;
    static int[][] map;
    static int[][] wormHole;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int ans;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;

            N = Integer.parseInt(br.readLine().trim());
            map = new int[N + 2][N + 2];
            wormHole = new int[5][4];
            
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] >= 6 && map[i][j] <= 10) {
                        if (wormHole[map[i][j] - 6][0] == 0) {
                            wormHole[map[i][j] - 6][0] = i;
                            wormHole[map[i][j] - 6][1] = j;
                        } else {
                            wormHole[map[i][j] - 6][2] = i;
                            wormHole[map[i][j] - 6][3] = j;
                        }
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = -1;
                        
                        logic(i, j, 0);
                        logic(i, j, 1);
                        logic(i, j, 2);
                        logic(i, j, 3);
                        
                        map[i][j] = 0;
                    }
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void logic(int x, int y, int dir) {
        int score = 0;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x == 0 || x == N + 1 || y == 0 || y == N + 1) {
                score++;
                if (dir == 0 || dir == 1) dir+=2;
                else dir-=2;
            } else if (map[x][y] >= 1 && map[x][y] <= 5) {
                score++;
                dir = reflection(dir, map[x][y]);
            } else if (map[x][y] >= 6 && map[x][y] <= 10) {
                if (wormHole[map[x][y] - 6][0] == x && wormHole[map[x][y] - 6][1] == y) {
                    int tempX = x;
                    x = wormHole[map[x][y] - 6][2];
                    y = wormHole[map[tempX][y] - 6][3];
                } else {
                    int tempX = x;
                    x = wormHole[map[x][y] - 6][0];
                    y = wormHole[map[tempX][y] - 6][1];
                }
            } else if (map[x][y] == -1) {
                ans = Math.max(ans, score);
                return;
            }
        }
    }

    static int reflection(int dir, int type) {
        switch (dir) {
            case 0:
                if (type == 1 || type == 4 || type == 5) return 2;
                else if (type == 2) return 1;
                else if (type == 3) return 3;
                break;
            case 1:
                if (type == 1 || type == 2 || type == 5) return 3;
                else if (type == 3) return 2;
                else if (type == 4) return 0;
                break;
            case 2:
                if (type == 2 || type == 3 || type == 5) return 0;
                else if (type == 1) return 1;
                else if (type == 4) return 3;
                break;
            case 3:
                if (type == 3 || type == 4 || type == 5) return 1;
                else if (type == 1) return 0;
                else if (type == 2) return 2;
                break;
        }
        return 0;
    }
}
