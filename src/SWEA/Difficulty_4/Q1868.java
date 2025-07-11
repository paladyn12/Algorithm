package SWEA.Difficulty_4;

import java.util.*;
import java.io.*;

class Q1868
{
    static boolean[][] visit;
    static char[][] chars;
    static int N;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];
            chars = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    chars[i][j] = str.charAt(j);
                }
            }

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == false && chars[i][j] != '*' && findNumber(i, j) == 0) {
                        result++;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (chars[i][j] == '.') {
                        chars[i][j] = (char) (findNumber(i, j) + '0');
                        visit[i][j] = true;
                        result++;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
    static int findNumber(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
            if (chars[nextX][nextY] == '*') count++;
        }
        return count;
    }

    static void bfs(int x, int y) {
        ArrayDeque<char[]> queue = new ArrayDeque<>();
        visit[x][y] = true;
        queue.addLast(new char[] {(char) (x + '0'), (char) (y + '0')});

        while (!queue.isEmpty()) {
            char[] cur = queue.pollFirst();
            int cx = cur[0] - '0';
            int cy = cur[1] - '0';
            int count = findNumber(cx, cy);
            chars[cx][cy] = (char) (count + '0');
            if (count > 0) {
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] == false && chars[nx][ny] != '*') {
                    visit[nx][ny] = true;
                    queue.addLast(new char[] {(char) (nx + '0'), (char) (ny + '0')});
                }
            }
        }
    }
}