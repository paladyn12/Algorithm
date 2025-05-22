package BAEKJOON.비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11723
 * 문제 이름: 집합
 * 풀이: 비스마스킹 연산
 */
class Q11723_비트마스킹 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int bitmask = 0;

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (cmd) {
                case "add":
                    bitmask |= (1 << x - 1);
                    break;
                case "remove":
                    bitmask &= ~(1 << x - 1);
                    break;
                case "check":
                    if ((bitmask & (1 << (x - 1))) != 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    bitmask ^= (1 << (x - 1));
                    break;
                case "all":
                    bitmask = (1 << 20) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}