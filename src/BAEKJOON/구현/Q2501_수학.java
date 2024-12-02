package BAEKJOON.구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2501
 * 문제 이름: 약수 구하기
 * 문제 링크: https://www.acmicpc.net/problem/2501
 * 풀이: K를 입력받아 1부터 약수 비교를 진행하고 K번째 약수이면 stop
 */
class Q2501_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean flag = true;

        for (int i = 1; i <= N; i++) {
            if (N%i == 0) {
                count++;
                if (count == K) {
                    bw.write(String.valueOf(i));
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            bw.write(String.valueOf(0));
        }
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}