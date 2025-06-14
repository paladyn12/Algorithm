package BAEKJOON.구현.수학;

import java.io.*;

/**
 * 문제 번호: 1094
 * 문제 이름: 막대기
 * 풀이 : 2진수로 변환했을 때의 1의 개수 출력
 */

class Q1094_수학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int count = 0;
        while (X > 0) {
            if (X % 2 == 0) {
                X /= 2;
            }
            else {
                X /= 2;
                count++;
            }
        }
        System.out.println(count);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}