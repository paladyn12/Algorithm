package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q1959 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arrN = new int[N];
            int[] arrM = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arrN[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) arrM[i] = Integer.parseInt(st.nextToken());

            int result = (N > M) ? getMaxProduct(arrN, arrM) : getMaxProduct(arrM, arrN);
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int getMaxProduct(int[] longer, int[] shorter) {
        int max = Integer.MIN_VALUE;
        int diff = longer.length - shorter.length + 1;
        for (int i = 0; i < diff; i++) {
            int sum = 0;
            for (int j = 0; j < shorter.length; j++) {
                sum += longer[i + j] * shorter[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}