package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q1961
{
    static int N;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
            N = Integer.parseInt(br.readLine());

            int[][] array90 = new int[N][N];
            int[][] array180 = new int[N][N];
            int[][] array270 = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    array90[j][N-i-1] = number;
                    array180[N-i-1][N-j-1] = number;
                    array270[N-j-1][i] = number;
                }
            }
            sb.append("#").append(test_case).append("\n");

            for (int i = 0; i < N; i++) {
                for (int num : array90[i]) {
                    sb.append(num);
                }
                sb.append(" ");
                for (int num : array180[i]) {
                    sb.append(num);
                }
                sb.append(" ");
                for (int num : array270[i]) {
                    sb.append(num);
                }
                sb.append(" ");
                sb.append("\n");
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
        System.out.println(sb);
    }
}