package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2609
 * 문제 이름: 최대공약수와 최소공배수
 * 풀이: 최대공약수와 최소공배수 계산
 */
class Q2609_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int com = GCD(A, B);
        sb.append(com).append("\n");
        sb.append((A*B)/com).append("\n");

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