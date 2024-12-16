package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1934
 * 문제 이름: 최소공배수
 * 문제 링크: https://www.acmicpc.net/problem/1934
 * 풀이: GCD를 구해 sb에 담아 출력
 */
class Q1934_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int A;
        int B;
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(A*B/GCD(A, B)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a%b);
    }

}