import java.io.*;
import java.util.*;


public class Q17136_브루트포스 {

    static boolean[][] paper = new boolean[10][10];
    static int ans = Integer.MAX_VALUE;
    static int space = 0;
    static boolean[][][] sticked = new boolean[10][10][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) paper[i][j] = true;
                else paper[i][j] = false;
                space += n;
            }
        }

        dfs(5, 5, 5, 5, 5, 0, 0);

        if (ans == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(ans);
    }

    static void dfs(int one, int two, int three, int four, int five, int cover, int cnt) {
        if (cnt >= ans) return;
        if (cover == space) {
            ans = Math.min(ans, cnt);
            return;
        }

        int x = -1, y = -1;
        // 덮이지 않은 첫 번째 칸 찾기
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j]) {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }

        // 더 이상 덮을 칸 없음
        if (x == -1) return;

        // 큰 종이부터 시도
        for (int size = 5; size >= 1; size--) {
            if (!check(x, y, size)) continue;

            if (size == 1 && one == 0) continue;
            if (size == 2 && two == 0) continue;
            if (size == 3 && three == 0) continue;
            if (size == 4 && four == 0) continue;
            if (size == 5 && five == 0) continue;

            // 붙이기
            stick(x, y, size, false);

            if (size == 1) dfs(one - 1, two, three, four, five, cover + 1, cnt + 1);
            if (size == 2) dfs(one, two - 1, three, four, five, cover + 4, cnt + 1);
            if (size == 3) dfs(one, two, three - 1, four, five, cover + 9, cnt + 1);
            if (size == 4) dfs(one, two, three, four - 1, five, cover + 16, cnt + 1);
            if (size == 5) dfs(one, two, three, four, five - 1, cover + 25, cnt + 1);

            // 되돌리기
            stick(x, y, size, true);
        }
    }

    // 해당 좌표에서 size 크기의 종이를 붙일 수 있는가?
    static boolean check(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            int nx = x + i;
            for (int j = 0; j < size; j++) {
                int ny = y + j;
                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) return false;
                if (!paper[nx][ny]) return false;
            }
        }
        return true;
    }

    // 종이 붙이기 / 떼기
    static void stick(int x, int y, int size, boolean flag) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[x + i][y + j] = flag;
            }
        }
    }
}
