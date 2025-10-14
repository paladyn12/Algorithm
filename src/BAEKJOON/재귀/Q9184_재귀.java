import java.io.*;
import java.util.*;

public class Q9184_재귀 {

    static int[][][] memo = new int[21][21][21];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w(20, 20, 20);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (a != -1 || b != -1 || c != -1) {
            int result;
            if (a <= 0 || b <= 0 || c <= 0) {
               result = 1; 
            } else if (a > 20 || b > 20 || c > 20) {
                result = w(20, 20, 20);
            } else {
                result = w(a, b, c);
            }
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a < b && b < c) {
            if (memo[a][b][c] == 0) {
                memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
                //System.out.println(a + " " + b + " " + c + " : " + memo[a][b][c]);
                return memo[a][b][c];
            } else {
                return memo[a][b][c];
            }
        } else {
            if (memo[a][b][c] == 0) {
                memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
                //System.out.println(a + " " + b + " " + c + " : " + memo[a][b][c]);
                return memo[a][b][c];
            } else {
                return memo[a][b][c];
            }
        }
        
    }
}
