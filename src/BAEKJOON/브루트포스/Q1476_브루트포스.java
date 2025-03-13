package BAEKJOON.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1476
 * 문제 이름: 날짜 계산
 * 풀이: 변수 e, s, m을 조건에 맞게 1씩 증가시켜 입력된 E, S, M과 같을 때 까지 반복
 */
class Q1476_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()) - 1;
        int S = Integer.parseInt(st.nextToken()) - 1;
        int M = Integer.parseInt(st.nextToken()) - 1;

        int year = 1;
        int e = 0;
        int s = 0;
        int m = 0;
        while (true) {
            if (e == E && s == S && m == M) break;

            e = (e + 1) % 15;
            s = (s + 1) % 28;
            m = (m + 1) % 19;
            year++;
        }

        System.out.println(year);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}