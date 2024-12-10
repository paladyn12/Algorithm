package BAEKJOON.자료구조.문자열;

import java.io.*;

/**
 * 문제 번호: 10820
 * 문제 이름: 문자열 분석
 * 문제 링크: https://www.acmicpc.net/problem/10820
 * 풀이: while ((string = br.readLine()) != null) 문으로 계속해서 값을 입력받음
 * ctrl+D로 종료
 * 문자가 소문자, 대문자, 숫자, 공백일 때 count할 index를 logic 메서드로 구현
 */
class Q10820_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String string;
        StringBuilder sb = new StringBuilder();
        while ((string = br.readLine()) != null) {
            int[] result = new int[4];
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                result[logic(ch)]++;
            }
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    private static int logic(char ch) {
        if (ch >= 97 && ch <= 122) {
            return 0;
        } else if (ch >= 65 && ch <= 90) {
            return 1;
        } else if (ch >= 48 && ch <= 57) {
            return 2;
        } else if (ch == 32) {
            return 3;
        }
        return 0;
    }
}