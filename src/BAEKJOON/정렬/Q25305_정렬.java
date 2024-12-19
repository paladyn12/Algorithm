package BAEKJOON.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 문제 번호: 25305
 * 문제 이름: 커트라인
 * 풀이: 정렬하여 k번째 점수 반환
 */
class Q25305_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] score = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) score[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(score, Comparator.reverseOrder());
        System.out.println(score[k-1]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}
