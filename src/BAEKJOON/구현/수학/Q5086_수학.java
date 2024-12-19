package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 5086
 * 문제 이름: 배수와 약수
 * 풀이: 앞 수가 더 작을 때, 뒷 수 % 앞 수 == 0 이면 factor
 * 앞 수가 더 클 때, 앞 수 % 뒷 수 == 0 일 때 multiple
 */
class Q5086_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            if (first+last==0) {
                break;
            }
            if (first < last) {
                if (last%first==0) sb.append("factor\n");
                else sb.append("neither\n");
            } else {
                if (first%last==0) sb.append("multiple\n");
                else sb.append("neither\n");
            }
        }
        System.out.print(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}