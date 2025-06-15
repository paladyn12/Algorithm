import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이 :
 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime,true);
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= 1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        int n;
        StringBuilder sb = new StringBuilder();
        while (true) {
            n = Integer.parseInt(br.readLine());
            boolean flag = false;
            if (n == 0) break;
            for (int i = 3; i <= n/2; i+=2) {
                if (isPrime[i] && isPrime[n-i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}