package BAEKJOON.시간복잡도;

import java.io.*;
/**
 * 문제 번호: 24263
 * 문제 이름: 알고리즘 수업 - 알고리즘의 수행 시간 2
 * 풀이: 주어진 메서드는 주어진 n에 대해 n번 배열 접근이 이루어짐
 * 즉 f(n) = n 으로 나타낼 수 있으며 수행 횟수는 n회이고 최고차항은 1
 */
class Q24263_시간복잡도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        System.out.print(N+"\n1");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}