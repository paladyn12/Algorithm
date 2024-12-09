package BAEKJOON.자료구조.시간복잡도;

import java.io.*;
/**
 * 문제 번호: 24265
 * 문제 이름: 알고리즘 수업 - 알고리즘의 수행 시간 4
 * 문제 링크: https://www.acmicpc.net/problem/24265
 * 풀이: 주어진 메서드는 주어진 n에 대해 n*(n-1)/2 번 연산을 수행
 * 즉 f(n) = 1/2(n*2-n) 이고 수행 횟수는 n*(n-1)/2, 최고차항은 2
 */
class Q24265_시간복잡도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        long N = Integer.parseInt(br.readLine());
        System.out.print((N*(N-1))/2+"\n2");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}