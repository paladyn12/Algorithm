import java.io.*;
import java.util.*;

public class Q5643 {

    static boolean[][] reach;
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            reach = new boolean[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                reach[s][e] = true;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    if (reach[i][k]) {
                        for (int j = 1; j <= N; j++) {
                            if (reach[k][j]) {
                                reach[i][j] = true;
                            }
                        }
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    if (reach[i][j] || reach[j][i]) sum++;
                }
                if (sum == N - 1) ans++;
            }
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}
