package BAEKJOON.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1931
 * 문제 이름: 회의실 배정
 * 풀이: 회의가 끝나는 시간을 기준으로 Sort
 * 각 회의의 시작 시간이 저장했던 endTime 보다 크거나 같으면 (이전 회의가 끝난 이후의 회의이면)
 * 그 회의를 시작하는 것으로 가정하여 endTime을 그 회의의 종료 시간으로 초기화
 */
class Q1931_그리디 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (t1, t2) -> {
            if (t1[1] == t2[1]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });

        int endTime = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (info[i][0] >= endTime) {
                count++;
                endTime = info[i][1];
            }
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}