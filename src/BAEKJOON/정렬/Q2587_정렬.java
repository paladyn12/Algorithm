package BAEKJOON.정렬;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 2587
 * 문제 이름: 대표값2
 * 문제 링크: https://www.acmicpc.net/problem/2587
 * 풀이: sort 후 중앙 인덱스의 값
 */
class Q2587_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int[] nums = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        sb.append(sum/5).append("\n").append(nums[2]);
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
