import java.util.*;
import java.io.*;

class Tank {
    int x;
    int y;
    // 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
    int direction;
}

class Q1873 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;
    static char[][] map;
    static int H;
    static int W;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;

            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            int tankX = 0;
            int tankY = 0;
            int tankDir = 0;

            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '<') {
                        tankX = i;
                        tankY = j;
                        switch (map[i][j]) {
                            case '^':
                                tankDir = 0;
                                break;
                            case '>':
                                tankDir = 1;
                                break;
                            case 'v':
                                tankDir = 2;
                                break;
                            case '<':
                                tankDir = 3;
                                break;
                        }
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String operations = br.readLine();
            for (int i = 0; i < N; i++) {
                char oper = operations.charAt(i);
                switch(oper) {
                    case 'U':
                        tankDir = 0;
                        map[tankX][tankY] = '^';
                        if (tankX - 1 < 0 || map[tankX - 1][tankY] == '*' || map[tankX - 1][tankY] == '#' || map[tankX - 1][tankY] == '-') break;
                        map[tankX--][tankY] = '.';
                        map[tankX][tankY] = '^';
                        break;
                    case 'R':
                        tankDir = 1;
                        map[tankX][tankY] = '>';
                        if (tankY + 1 >= W || map[tankX][tankY + 1] == '*' || map[tankX][tankY + 1] == '#' || map[tankX][tankY + 1] == '-') break;
                        map[tankX][tankY++] = '.';
                        map[tankX][tankY] = '>';
                        break;
                    case 'D':
                        tankDir = 2;
                        map[tankX][tankY] = 'v';
                        if (tankX + 1 >= H || map[tankX + 1][tankY] == '*' || map[tankX + 1][tankY] == '#' || map[tankX + 1][tankY] == '-') break;
                        map[tankX++][tankY] = '.';
                        map[tankX][tankY] = 'v';
                        break;
                    case 'L':
                        tankDir = 3;
                        map[tankX][tankY] = '<';
                        if (tankY - 1 < 0 || map[tankX][tankY - 1] == '*' || map[tankX][tankY - 1] == '#' || map[tankX][tankY - 1] == '-') break;
                        map[tankX][tankY--] = '.';
                        map[tankX][tankY] = '<';
                        break;
                    case 'S':
                        shoot(tankX, tankY, tankDir);
                        break;
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static void shoot(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx >= 0 && nx < H && ny >= 0 && ny < W) {
            if (map[nx][ny] == '*') {
                map[nx][ny] = '.';
                return;
            } else if (map[nx][ny] == '#') {
                return;
            }

            nx += dx[dir];
            ny += dy[dir];
        }
    }
}
