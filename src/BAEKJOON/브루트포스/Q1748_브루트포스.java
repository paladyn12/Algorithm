package BAEKJOON.브루트포스;

import java.io.*;

/**
 * 문제 번호: 1748
 * 문제 이름: 수 이어 쓰기 1
 * 풀이: 입력 N을 자릿수로 나눠 연산
 */
class Q1748_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String s = br.readLine();
        int L = s.length(); // 120
        int sum = 0;
        for (int i = 1; i < L; i++) {
            sum += (int) (9 * (i * Math.pow(10, i-1)));
        }
        sum += (int) (L * (Integer.parseInt(s) - Math.pow(10, L - 1) + 1));

        System.out.println(sum);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}