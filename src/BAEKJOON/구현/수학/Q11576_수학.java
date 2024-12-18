package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11576
 * 문제 이름: Base Conversion
 * 문제 링크: https://www.acmicpc.net/problem/11576
 * 풀이: 10진법으로 먼저 변환 후 B 진법으로 변환
 */
class Q11576_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // A진법
        int B = Integer.parseInt(st.nextToken()); // B진법
        int m = Integer.parseInt(br.readLine()); // m자릿수
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = m-1; i >= 0; i--) {
            sum += (int) (Math.pow(A, i) * Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        while (sum > 0) {
            sb.insert(0, sum % B);
            sb.insert(0, " ");
            sum /= B;
        }
        bw.write(sb.substring(1));
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}