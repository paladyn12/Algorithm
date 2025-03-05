import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int five = logic(N, 5) - logic(N-M, 5) - logic(M, 5);
        int two = logic(N, 2) - logic(N-M, 2) - logic(M, 2);


        int result = Math.min(two, five);
        if (result <= 0) {
            System.out.println(0);
        } else System.out.println(result);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    public static int logic(int n, int d) {
        int sum = 0;
        while (n > 0) {
            sum += n / d;
            n /= d;
        }
        return sum;
    }
}