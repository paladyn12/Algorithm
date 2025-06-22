package BAEKJOON.구현.일반;

import java.io.*;

/**
 * 문제 번호: 11023
 * 문제 이름: 더하기 3
 * 풀이 :
 */

class Q11023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] split = br.readLine().split(" ");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}