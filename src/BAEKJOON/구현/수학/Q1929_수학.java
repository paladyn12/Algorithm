package BAEKJOON.구현.수학;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1929
 * 문제 이름: 소수 구하기
 * 문제 링크: https://www.acmicpc.net/problem/1929
 * 풀이: 범위 내 자연수에 대해 isPrime이 true이면 출력
 */
class Q1929_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[N+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (primes[i]) {
                for (int j = i*2; j <= N; j+=i) {
                    primes[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (primes[i]) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
