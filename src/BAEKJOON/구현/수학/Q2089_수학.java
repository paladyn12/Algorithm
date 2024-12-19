package BAEKJOON.구현.수학;

import java.io.*;

/**
 * 문제 번호: 2089
 * 문제 이름: -2진수
 * 풀이: -2로 나누며 진법 변환
 * 나머지가 -1인 경우 보정
 */
class Q2089_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            while (N != 0) {
                int r = N % -2;
                N /= -2;
                if (r < 0) {
                    r += 2;
                    N++;
                }
                sb.insert(0, r);
            }
            bw.write(sb.toString());
            bw.flush();
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
