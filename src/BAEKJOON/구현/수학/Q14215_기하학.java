package BAEKJOON.구현.수학;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 14215
 * 문제 이름: 세 막대
 * 풀이: a,b,c를 입력받아 가장 큰 수를 찾음
 * 가장 큰 수 < 나머지 합 이면 바로 총 합 계산
 * 아니면 가장 큰 수 < 나머지 합 일 때까지 가장 큰 수를 줄여 합 계산
 */
class Q14215_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] poll = new int[3];
        poll[0] = Integer.parseInt(st.nextToken());
        poll[1] = Integer.parseInt(st.nextToken());
        poll[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(poll);
        if (poll[2] >= poll[0] + poll[1]) poll[2] = poll[0] + poll[1] - 1;

        bw.write(String.valueOf(poll[0]+poll[1]+poll[2]));
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}