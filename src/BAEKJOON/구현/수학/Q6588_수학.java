package BAEKJOON.구현.수학;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 6588
 * 문제 이름: 골드바흐의 추측
 * 문제 링크: https://www.acmicpc.net/problem/6588
 * 풀이: 각 수를 3, n-3 먼저 검사, 두 수가 소수가 아니면 각 수에 +2, -2
 */
class Q6588_수학 {
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