package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1085
 * 문제 이름: 직사각형에서 탈출
 * 문제 링크: https://www.acmicpc.net/problem/1085
 * 풀이: x, y, w-x, h-y의 최솟값
 */
class Q1085_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Math.min(Math.min(x, y), Math.min(w-x, h-y))));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}