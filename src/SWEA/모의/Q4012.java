import java.io.*;
import java.util.*;

public class Q4012 {

    static int N;
    static int ans;
    static boolean[] visit;
    static int[] foodA;
    static int[] foodB;
    static int[][] S;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	
            N = Integer.parseInt(br.readLine());
            ans = Integer.MAX_VALUE;
            

            S = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visit = new boolean[N];
            foodA = new int[N / 2];
            foodB = new int[N / 2];
            dfs(0, 0);
            
            
        	sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
	}

    static void dfs(int start, int depth) {
        if (depth == N / 2) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < N; i++) {
                if (visit[i]) foodA[a++] = i;
                else foodB[b++] = i;
            }

            //System.out.println("A : " + logic(foodA));
            //System.out.println("B : " + logic(foodB));
            int calc = Math.abs(logic(foodA) - logic(foodB));
            ans = Math.min(ans, calc);
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    static int logic(int[] food) {
        int sum = 0;
        for (int f1 : food) {
            for (int f2 : food) {
                if (f1 == f2) continue;
                sum += S[f1][f2];
            }
        }
        return sum;
    }
}
