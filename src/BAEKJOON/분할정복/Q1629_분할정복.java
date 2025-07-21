import java.util.*;
import java.io.*;

class Q1629_분할정복 {

    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(pow(A, B));
        
    }

    static long pow(int base, int exp) {
        if (exp == 1) {
            return base % C;
        }
        
        long temp = pow(base, exp / 2);
        if (exp % 2 == 1) {
            return (temp * temp % C) * base % C;
        } else {
            return temp * temp % C;
        }
        
    }
}
