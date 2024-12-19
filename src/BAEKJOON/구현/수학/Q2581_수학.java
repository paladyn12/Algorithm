package BAEKJOON.구현.수학;

import java.io.*;

/**
 * 문제 번호: 2581
 * 문제 이름: 소수
 * 풀이: N까지의 소수값을 미리 저장하고 N부터 M까지 역순으로 소수를 찾음
 */
class Q2581_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[1] = true;
        for (int i = 2; i*i <= N; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i*i; j <= N; j+=i) {
                isNotPrime[j] = true;
            }
        }

        int sum = 0;
        int minPrime = Integer.MAX_VALUE;
        for (int i = N; i >= M; i--) {
            if (!isNotPrime[i]) {
                sum += i;
                minPrime = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(minPrime);
        }
        System.out.print(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}