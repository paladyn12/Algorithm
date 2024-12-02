package BAEKJOON.구현.수학;

import java.io.*;
import java.util.ArrayList;

/**
 * 문제 번호: 9506
 * 문제 이름: 약수들의 합
 * 문제 링크: https://www.acmicpc.net/problem/9506
 * 풀이: n/2까지 찾은 약수들을 더해 n과 같은지 판별
 */
class Q9506_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N != -1) {
            int sum = 0;
            ArrayList<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= N/2; i++) {
                if (N%i==0) {
                    sum += i;
                    factors.add(i);
                }
            }
            if (sum == N) {
                sb.append(N).append(" = ");
                for (int i = 0; i < factors.size(); i++) {
                    if (i == factors.size()-1) {
                        sb.append(factors.get(i)).append("\n");
                    } else sb.append(factors.get(i)).append(" + ");
                }
            } else {
                sb.append(N).append(" is NOT perfect.\n");
            }
            N = Integer.parseInt(br.readLine());
        }

        System.out.print(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}