package BAEKJOON.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 10811
 * 문제 이름: 바구니 뒤집기
 * 문제 링크: https://www.acmicpc.net/problem/10811
 * 풀이: 역순으로 만드는 함수를 구현하여 각 범위마다 함수 호출
 */
class Q10811_일차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bucket = new int[N];
        for (int i = 0; i < N; i++) {
            bucket[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            reverse(bucket, from, to);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : bucket) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static void reverse(int[] bucket, int from, int to) {
        int[] step = new int[to-from+1];
        for (int i = 0; i < step.length; i++) {
            step[i] = bucket[i+from];
        }
        for (int i = 0; i < step.length; i++) {
            bucket[i+from] = step[step.length-i-1];
        }
    }
}