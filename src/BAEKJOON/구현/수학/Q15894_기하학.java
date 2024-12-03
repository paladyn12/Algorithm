package BAEKJOON.구현.수학;

import java.io.*;
/**
 * 문제 번호: 15894
 * 문제 이름: 수학은 체육과목 입니다
 * 문제 링크: https://www.acmicpc.net/problem/15894
 * 풀이: 4n
 */
class Q15894_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        long n = Long.parseLong(br.readLine());

        bw.write(String.valueOf(4*n));
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}