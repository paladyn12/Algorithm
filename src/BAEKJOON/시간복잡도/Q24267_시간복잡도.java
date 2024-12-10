package BAEKJOON.시간복잡도;

import java.io.*;
/**
 * 문제 번호: 24267
 * 문제 이름: 알고리즘 수업 - 알고리즘의 수행 시간 6
 * 문제 링크: https://www.acmicpc.net/problem/24267
 * 풀이: 주어진 메서드는 주어진 n에 대해 n(n-1)(n-2)/6 번 연산 수행
 * 즉 f(n) = n(n-1)(n-2)/6 이며 수행 횟수는 n(n-1)(n-2)/6, 최고차항은 3
 */
class Q24267_시간복잡도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        long N = Integer.parseInt(br.readLine());
        System.out.print((N*(N-1)*(N-2))/6+"\n3");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}