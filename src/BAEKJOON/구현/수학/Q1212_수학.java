package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 1212
 * 문제 이름: 8진수 2진수
 * 문제 링크: https://www.acmicpc.net/problem/1212
 * 풀이: 각 자릿수를 2진수로 변환하여 SB에 더함
 */
class Q1212_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(logic(s.charAt(i)));
        }
        s = sb.toString();
        int i = s.indexOf('1');
        if (i != -1)
            System.out.println(sb.substring(i));
        else System.out.println(0);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static String logic(char c) {
        int n = c - '0';
        switch (n) {
            case 0:
                return "000";
            case 1:
                return "001";
            case 2:
                return "010";
            case 3:
                return "011";
            case 4:
                return "100";
            case 5:
                return "101";
            case 6:
                return "110";
            case 7:
                return "111";
        }
        return "";
    }
}