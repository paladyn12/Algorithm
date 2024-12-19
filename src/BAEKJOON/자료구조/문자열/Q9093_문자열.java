package BAEKJOON.자료구조.문자열;

import java.io.*;
/**
 * 문제 번호: 9093
 * 문제 이름: 단어 뒤집기
 * 풀이: 입력 문자열을 공백 단위로 분류하여 각 단어별로 뒤집기
 */
class Q9093_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                StringBuilder temp = new StringBuilder(new String(split[j]));
                temp.reverse();
                sb.append(temp).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}