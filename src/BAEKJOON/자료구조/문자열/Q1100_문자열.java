package BAEKJOON.자료구조.문자열;

import java.io.*;

/**
 * 문제 번호: 1100
 * 문제 이름: 하얀 칸
 * 풀이 : 하얀 칸에 F가 나오면 count++
 */

class Q1100_문자열 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int count = 0;

        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && s.charAt(j) == 'F') count ++;
            }
        }

        System.out.println(count);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}