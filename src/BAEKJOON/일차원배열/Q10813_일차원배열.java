package BAEKJOON.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 10813
 * 문제 이름: 공 바꾸기
 * 문제 링크: https://www.acmicpc.net/problem/10813
 * 풀이: int[]와 index 둘을 입력받아 값을 바꾸는 함수를 만들어 구현
 */
class Q10813_일차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bucket = new int[N];

        // 맨 처음 각 바구니에 바구니 번호를 가진 공이 들어있음
        for (int i = 0; i < N; i++) {
            bucket[i] = i+1;
        }

        // M번 교환
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            swap(bucket, from, to);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : bucket) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static void swap(int[] bucket, int from, int to) {
        int step = bucket[from];
        bucket[from] = bucket[to];
        bucket[to] = step;
    }
}