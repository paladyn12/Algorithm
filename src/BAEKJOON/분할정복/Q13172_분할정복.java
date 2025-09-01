import java.io.*;
import java.util.*;

public class Q13172_분할정복 {

    // 모듈러 연산에 사용할 소수
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        long totalExpectation = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            long N_inverse = power(N, MOD - 2);

            long currentExpectation = (S * N_inverse) % MOD;

            totalExpectation = (totalExpectation + currentExpectation) % MOD;
        }

        System.out.print(totalExpectation);
    }

    static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            // 지수가 홀수이면 result에 base를 곱함
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            // base를 제곱하고 지수는 절반으로 나눔
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}
