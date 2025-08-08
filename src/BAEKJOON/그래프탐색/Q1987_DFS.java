import java.io.*;
import java.util.*;

public class Q1987_DFS {

    static int R;
    static int C;
    static int result = 0;
    static boolean[] usedAlpha = new boolean[26];
    static boolean[][] visit;
    static char[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new boolean[R][C];
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        char startChar = board[0][0];
        usedAlpha[startChar - 'A'] = true;
        visit[0][0] = true;
        dfs(0, 0, 1);
        
        System.out.print(result);
    }

    static void dfs(int x, int y, int cnt) {
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            char nc = board[nx][ny];
            if (visit[nx][ny] || usedAlpha[nc - 'A']) continue;
            visit[nx][ny] = true;
            usedAlpha[nc - 'A'] = true;
            dfs(nx, ny, cnt + 1);
            visit[nx][ny] = false;
            usedAlpha[nc - 'A'] = false;
        }
    }
    
}
