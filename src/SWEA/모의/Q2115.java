import java.io.*;
import java.util.*;

public class Q2115 {

    static int[][] map;
    static int[][] sum;
    static int dfsResult;
    static int ans;
    static int N;
    static int M;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            sum = new int[N][N - M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    sum[i][j] = logic(i, j);
                }
            }

            if (M <= N / 2) {
                for (int r = 0; r < N; r++) {
                    for (int i = 0; i <= N - 2 * M; i++) {
                        for (int j = i + M; j <= N - M; j++) {
                            ans = Math.max(ans, sum[r][i] + sum[r][j]);
                        }
                    }
                }
            }

            for (int i = 0; i < N - 1; i++) {
                int m1 = findMax(sum[i]);
                for (int j = i + 1; j < N; j++) {
                    ans = Math.max(ans, m1 + findMax(sum[j]));
                }
            }

            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb);
    }

    static int logic(int x, int y) {
        int[] temp = new int[M];
        for (int i = 0; i < M; i++) {
            temp[i] = map[x][y + i];
        }
        dfsResult = 0;
        dfs(temp, 0, 0, 0);
        return dfsResult;
    }

    static void dfs(int[] array, int start, int sum, int result) {
        if (sum > C) return;
        dfsResult = Math.max(dfsResult, result);
        for (int i = start; i < M; i++) {
            dfs(array, i + 1, sum + array[i], result + array[i] * array[i]);
        }
    }

    static int findMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
