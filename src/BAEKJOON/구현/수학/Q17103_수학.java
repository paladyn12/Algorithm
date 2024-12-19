package BAEKJOON.구현.수학;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 17103
 * 문제 이름: 골드바흐 파티션
 * 풀이: 소수 판별을 위해 배열을 미리 만들고 골드바흐 추측의 소수 판열에 사용
 */
class Q17103_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int test_case = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= 1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {
            int input = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 2; i <= input/2; i++) {
                if (isPrime[i] && isPrime[input-i]) count++;

            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
