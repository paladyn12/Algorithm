package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 5073
 * 문제 이름: 삼각형과 세 변
 * 풀이: 0 0 0이 입력되기 전 까지 while
 * 가장 긴 변의 길이를 추출해 조건 확인
 */
class Q5073_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int longest = Integer.parseInt(st.nextToken());
            int else1 = Integer.parseInt(st.nextToken());
            int else2 = Integer.parseInt(st.nextToken());

            if (longest + else1 + else2 == 0) break;
            if (longest < else1) {
                int temp = longest;
                longest = else1;
                else1 = temp;
            }
            if (longest < else2) {
                int temp = longest;
                longest = else2;
                else2 = temp;
            }
            if (longest >= else1 + else2) sb.append("Invalid\n");
            else {
                if (else1 == else2 && else2 == longest) sb.append("Equilateral\n");
                else if (else1 == else2 || else2 == longest || longest == else1) sb.append("Isosceles\n");
                else sb.append("Scalene\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}