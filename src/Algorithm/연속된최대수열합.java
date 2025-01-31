package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class 연속된최대수열합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }
        int[] tm = new int[N];
        int[] cm = new int[N];
        tm[0] = array[0];
        cm[0] = array[0];
        for (int i = 1; i < N; i++) {
            cm[i] = Math.max(cm[i-1] + array[i], array[i]);
            tm[i] = Math.max(tm[i-1], cm[i]);
        }

        System.out.println(tm[N-1]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
