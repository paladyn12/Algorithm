import java.util.*;
import java.io.*;

class Q30802_수학 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[6];
        for (int i = 0; i < 6; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            cnt += ((array[i] + T - 1) / T);
        }
        System.out.println(cnt);
        System.out.print(N / P + " " + N % P);
        
    }
}
