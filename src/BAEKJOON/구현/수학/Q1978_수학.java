package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1978
 * 문제 이름: 소수 찾기
 * 문제 링크: https://www.acmicpc.net/problem/1978
 * 풀이: 소수 판별 메서드를 만들어 각 수에 적용
 */
class Q1978_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isPrime(Integer.parseInt(st.nextToken()))) count++;
        }

        bw.write(String.valueOf(count));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    private static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num%i == 0) count++;
        }
        if (count == 2) return true;
        else return false;
    }
}