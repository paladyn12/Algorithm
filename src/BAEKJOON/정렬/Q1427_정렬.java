package BAEKJOON.정렬;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 1427
 * 문제 이름: 소트인사이드
 * 문제 링크: https://www.acmicpc.net/problem/1427
 * 풀이: 수를 String으로 받아 char[] 배열로 만들어 sort
 */
class Q1427_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String N = br.readLine();
        char[] nums = N.toCharArray();
        Arrays.sort(nums);

        // char[] -> String -> StringBuilder 에서 reverse -> String
        bw.write(new StringBuilder(new String(nums)).reverse().toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}