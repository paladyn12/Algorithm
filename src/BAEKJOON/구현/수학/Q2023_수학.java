import java.util.*;
import java.io.*;

class Q2023_수학 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(1, 2);
        dfs(1, 3);
        dfs(1, 5);
        dfs(1, 7);
        
        System.out.print(sb);
    }

    static void dfs(int depth, int current) {
        if (!isPrime(current)) return;
        if (depth == N) {
            sb.append(current).append("\n");
            return;
        }
        dfs(depth + 1, current * 10 + 1);
        dfs(depth + 1, current * 10 + 3);
        dfs(depth + 1, current * 10 + 7);
        dfs(depth + 1, current * 10 + 9);
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (i == n) return true;
            for (int j = i * i; j <= n; j+=i) {
                if (j == n) return false;
            }
        }
        return true;
    }
}
