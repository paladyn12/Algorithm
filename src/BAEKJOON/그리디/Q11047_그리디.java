package BAEKJOON.그리디;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 11047
 * 문제 이름: 동전 0
 * 풀이: 가장 큰 값부터 순차적으로 K를 나눈 몫을 더해나감
 */
class Q11047_그리디 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            count += K / A[i];
            K %= A[i];
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}