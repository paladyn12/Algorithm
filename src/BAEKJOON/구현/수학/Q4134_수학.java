import java.util.*;
import java.io.*;

class Q4134_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            if (N <= 2) System.out.println(2);
            else {
                while (true) {
                    if (isPrime(N)) {
                        System.out.println(N);
                        break;
                    } else {
                        if (N % 2 == 0) N++;
                        else N += 2;
                    }
                }
            }
           
        }
        
    }

    static boolean isPrime(long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
