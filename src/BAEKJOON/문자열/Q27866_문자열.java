package BAEKJOON.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 27866
 * 문제 이름: 문자와 문자열
 * 문제 링크: https://www.acmicpc.net/problem/27866
 * 풀이: charAt() 사용
 */
class Q27866_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String str = br.readLine();
        int i = Integer.parseInt(br.readLine());
        System.out.println(str.charAt(i-1));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}