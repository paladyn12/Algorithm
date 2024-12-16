package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2004
 * 문제 이름: 조합 0의 개수
 * 문제 링크: https://www.acmicpc.net/problem/2004
 * 풀이: nCm 에서 곱하는 수와 나누는 수에서 2와 5만 연산을 수행해 0 개수 찾기
 */
class Q2004_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int fives = logic(n,5) - logic(n-m,5) - logic(m,5);
        int twos = logic(n,2) - logic(n-m,2) - logic(m,2);
        System.out.println(Math.min(fives, twos));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static int logic(int n, int i) {
        int count = 0;
        while (n >= i) {
            count += n / i;
            n /= i;
        }
        return count;
    }
}