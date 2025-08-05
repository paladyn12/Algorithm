import java.util.*;
import java.io.*;

class Q4153_수학 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a != 0 || b != 0 || c != 0) {
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int middle = 0;
            if (a != max && a != min) middle = a;
            else if (b != max && b != min) middle = b;
            else  middle = c;

            if (max * max == min * min + middle * middle) sb.append("right\n");
            else sb.append("wrong\n");
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
}
