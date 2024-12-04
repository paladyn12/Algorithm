package BAEKJOON.브루트포스;

import java.io.*;
/**
 * 문제 번호: 2839
 * 문제 이름: 설탕 배달
 * 문제 링크: https://www.acmicpc.net/problem/2839
 * 풀이: while(N이 5 or 10의 배수가 아닐 때) N-=3
 */
class Q2839_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while ((N > 0) && !((N % 10 == 5) || (N % 10 == 0))) {
            N -= 3;
            count++;
        }
        if (N>=0) {
            count += N/5;
        } else count = -1;

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}