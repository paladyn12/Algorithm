package BAEKJOON.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 6064
 * 문제 이름: 카잉 달력
 * 풀이: M*N 횟수만큼 값을 증가시켜보고 유효한 년도가 없었으면 -1
 */
class Q6064_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken()); // <10, 12>
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1; // <3, 9>
            boolean success = false;

            // 항상 M 보다 N이 큰 상태에서 로직을 수행하도록 함
            if (M < N) {
                int temp = M;
                M = N;
                N = temp;
                temp = x;
                x = y;
                y = temp;
            }

            for (int i = x; i <= lcm(M, N); i+=M) {
                if (i % N == y) {
                    success = true;
                    sb.append(i+1).append("\n");
                    break;
                }

            }
            if (!success) {
                sb.append("-1\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}