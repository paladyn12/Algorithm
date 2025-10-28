import java.io.*;
import java.util.*;

public class Q9527_재귀 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.print(f(B) - f(A - 1));
    }

    static long f(long a) {
        if (a == 0) return 0;
        if (a == 1) return 1;
        if (a == 2) return 2;

        long base = 1;
        while (base * 2 <= a) {
            base *= 2;
        }

        return calc(base - 1) + f(a - base) + a - base + 1;
    }

    static long calc(long a) {
        if (a == 0) return 0;
        if (a == 1) return 1;
        if (a == 2) return 2;

        return 2 * calc(a / 2) + (a / 2 + 1);
    }
}
