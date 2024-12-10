package BAEKJOON.자료구조.문자열;

import java.io.*;

/**
 * 문제 번호: 10808
 * 문제 이름: 알파벳 개수
 * 문제 링크: https://www.acmicpc.net/problem/10808
 * 풀이: count 배열에 ch-'a'++
 */
class Q10808_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String s = br.readLine();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)-'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i : count) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
