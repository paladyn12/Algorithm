package BAEKJOON.시간복잡도;

import java.io.*;
/**
 * 문제 번호: 24266
 * 문제 이름: 알고리즘 수업 - 알고리즘의 수행 시간 5
 * 문제 링크: https://www.acmicpc.net/problem/24266
 * 풀이: 주어진 메서드는 주어진 n에 대해 n^3번 연산 수행
 * 즉 f(n) = n^3 이며 수행 횟수는 n^3, 최고차항은 3
 */
class Q24266_시간복잡도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        long N = Integer.parseInt(br.readLine());
        System.out.print(N*N*N+"\n3");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}