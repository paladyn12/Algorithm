package BAEKJOON.기본문제;

import java.util.Scanner;
/**
 * 문제 번호: 25314
 * 문제 이름: 코딩은 체육과목 입니다
 * 문제 링크: https://www.acmicpc.net/problem/25314
 * 풀이: N이 4의 배수이므로 4로 나눠 long을 더할 횟수를 구함
 */
class Q25314_기본문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        N /= 4;
        String result = "";
        for (int i = 0; i < N; i++) {
            result += "long ";
        }
        result += "int";
        System.out.print(result);
    }
}