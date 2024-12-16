package BAEKJOON.자료구조.일차원배열;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 11656
 * 문제 이름: 접미사 배열
 * 문제 링크: https://www.acmicpc.net/problem/11656
 * 풀이: substring으로 문자열을 잘라 배열에 넣고 sort
 */
class Q11656_일차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String s = br.readLine();
        String[] array = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.substring(i);
        }
        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (String string : array) {
            sb.append(string).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}