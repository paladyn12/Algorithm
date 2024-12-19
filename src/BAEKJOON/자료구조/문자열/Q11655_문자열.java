package BAEKJOON.자료구조.문자열;

import java.io.*;

/**
 * 문제 번호: 11655
 * 문제 이름: ROT13
 * 풀이: 공백, 숫자의 경우 바로 sb에 추가
 * 알파벳의 경우 13을 더한 값을 추가, 이 때 알파벳 범위를 넘어가면 -=26
 */

class Q11655_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(logic(s.charAt(i)));
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    private static char logic(char c) {
        if (c == 32 || (c >= 48 && c <= 57))
            return c;
        else {
            if (c >= 97 && c <= 122) {
                c += 13;
                if (c > 122) c -= 26;
            }
            if (c >= 65 && c <= 90) {
                c += 13;
                if (c > 90) c -= 26;
            }
            return c;
        }
    }
}