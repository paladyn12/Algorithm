package BAEKJOON.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 19532
 * 문제 이름: 수학은 비대면강의입니다
 * 문제 링크: https://www.acmicpc.net/problem/19532
 * 풀이: a, b, c, d, e, f에 대해 수식 생성
 * 모든 x, y 쌍을 검사
 */
class Q19532_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int num = a * e - b * d;

        int x = (c * e - b * f) / num;
        int y = (a * f - c * d) / num;

        System.out.println(x + " " + y);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}