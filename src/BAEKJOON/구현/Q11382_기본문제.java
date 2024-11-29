package BAEKJOON.구현;

import java.util.Scanner;

/**
 * 문제 번호: 11382
 * 문제 이름: 꼬마 정민
 * 문제 링크: https://www.acmicpc.net/problem/11382
 * 풀이: 입력 값이 int 범위를 넘어가므로 long 타입으로 입력받아 덧셈
 */
class Q11382_기본문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        System.out.print(A+B+C);
    }
}
