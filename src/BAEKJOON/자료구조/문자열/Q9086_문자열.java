package BAEKJOON.자료구조.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 9086
 * 문제 이름: 문자열
 * 문제 링크: https://www.acmicpc.net/problem/9086
 * 풀이: charAt(0)과 charAt(length-1)
 */
class Q9086_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int length = str.length();
            System.out.println(str.charAt(0) + "" + str.charAt(length-1));
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}