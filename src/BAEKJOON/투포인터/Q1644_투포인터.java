import java.io.*;
import java.util.*;

public class Q1644_투포인터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j+=i) isPrime[j] = false;
            }
        }
        for (int i = 2; i <= N; i++) if (isPrime[i]) primes.add(i);

        int ans = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < primes.size(); right++) {
            sum += primes.get(right);
            if (sum < N) continue;
            else if (sum == N) {
                ans++;
                continue;
            } else {
                while (sum > N) {
                    sum -= primes.get(left);
                    left++;
                    if (sum == N) ans++;
                }
            }
        }
        
        System.out.print(ans);
    }
}
