package BAEKJOON.구현;

import java.io.*;
/**
 * 문제 번호: 2903
 * 문제 이름: 중앙 이동 알고리즘
 * 문제 링크: https://www.acmicpc.net/problem/2903
 * 풀이: 입력값 N에 대해 각 줄의 상자 수를 구해 한 변의 점 수를 찾아 제곱
 */
class Q2903_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());

        // 한 줄당 박스의 수
        int boxPerLine = (int) Math.pow(2, N);
        // 박스 수 + 1 을 제곱하면 점의 수가 나옴
        int allDots = (int) Math.pow(boxPerLine + 1, 2);

        bw.write(String.valueOf(allDots));
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}