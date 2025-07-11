package SWEA.Difficulty_4;


import java.util.*;
import java.io.*;

class Q1486
{
    static int N;
    static int B;
    static boolean[] visit;
    static int[] H;
    static int currentTotal = 0;
    static int result;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visit = new boolean[N];
            H = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) H[i] = Integer.parseInt(st.nextToken());

            result = Integer.MAX_VALUE;
            dfs(0, 0);
            result -= B;
            /////////////////////////////////////////////////////////////////////////////////////////////
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int start, int depth) {
        if (currentTotal >= B) {
            result = Math.min(result, currentTotal);
            return;
        }
        if (depth == N) return;

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                currentTotal += H[i];
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
                currentTotal -= H[i];
            }
        }
    }
}