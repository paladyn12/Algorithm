import java.util.*;
import java.io.*;

class Q3421 {

    static int N;
    static int M;
    static int[] visit;
    static int result;
    static boolean[][] notGood;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            notGood = new boolean[N + 1][N + 1];
            visit = new int[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                notGood[s][e] = true;
                notGood[e][s] = true;
            }

            result = 0;
            dfs(1);

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        
        System.out.print(sb);
    }

    static void dfs(int start) {
        result++;

        for (int i = start; i <= N; i++) {
            if (visit[i] == 0) {
                visit[i]++;
                for (int j = 1; j <= N; j++) {
                    if (notGood[i][j]) visit[j]++;
                }
                dfs(i + 1);
                for (int j = 1; j <= N; j++) {
                    if (notGood[i][j]) visit[j]--;
                }
                visit[i]--;
            }
        }
    }
}
