import java.util.*;
import java.io.*;

class Q27433_재귀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.print(f(N));
    }

    static long f(long n) {
        if (n == 0 || n == 1) return 1;
        return n * f(n - 1);
    }
}
