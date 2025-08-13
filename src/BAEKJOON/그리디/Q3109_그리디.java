import java.util.*;
import java.io.*;

class Q3109_그리디 {

    static int ans = 0;
    static int R;
    static int C;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) == 'x' ? true : false;
            }
        }
        
        ans = 0;

        for (int i = 0; i < R; i++) {
            dfs(i, 0);            
        }
        
        System.out.print(ans);
    }

    static boolean dfs(int row, int col) {
        if (col == C - 1) {
            ans++;
            return true;
        }
        map[row][col] = true;
        
        if (row - 1 >= 0 && !map[row - 1][col + 1]) {
            if (dfs(row - 1, col + 1)) return true;
        }
        
        if (!map[row][col + 1]) {
            if (dfs(row, col + 1)) return true;
        }
        
        if (row + 1 < R && !map[row + 1][col + 1]) {
            if (dfs(row + 1, col + 1)) return true;
        }

        return false;
    }
}
