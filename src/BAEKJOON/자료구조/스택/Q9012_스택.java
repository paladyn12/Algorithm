package BAEKJOON.자료구조.스택;

import java.io.*;
/**
 * 문제 번호: 9012
 * 문제 이름: 괄호
 * 문제 링크: https://www.acmicpc.net/problem/9012
 * 풀이: 괄호 열기를 +1, 닫기를 -1로 하여 최종 값이 0이 아니거나 연산 중 음수가 되면 false
 */
class Q9012_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int count = 0;
            String string = br.readLine();
            int j;
            for (j = 0; j < string.length(); j++) {
                if (string.charAt(j) == '(') {
                    count++;
                } else count--;
                if (count < 0) {
                    sb.append("NO").append("\n");
                    break;
                }
            }
            if (j == string.length()) {
                if (count == 0) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}