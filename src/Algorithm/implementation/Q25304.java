package Algorithm.implementation;

import java.util.Scanner;

/**
 * 문제 번호: 25304
 * 문제 이름: 영수증
 * 문제 링크: https://www.acmicpc.net/problem/25304
 * 풀이: sum을 만들어 X와 각 물건의 가격 합이 일치하는지 확인
 */
class Q25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum += a*b;
        }
        if (X == sum) System.out.print("Yes");
        else System.out.print("No");
    }
}