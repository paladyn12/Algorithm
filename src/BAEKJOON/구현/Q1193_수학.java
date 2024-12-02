package BAEKJOON.구현;

import java.io.*;
/**
 * 문제 번호: 1193
 * 문제 이름: 분수찾기
 * 문제 링크: https://www.acmicpc.net/problem/1193
 * 풀이: +1, +2, +3,... 을 기준으로 탐색하는 층이 달라짐. 입력된 값 X가 몇 번째 층에서 탐색되는지 판별하기 위해 sum을 조건으로 while문을 돌리고 몇 번째 층인지 index에 저장
 * 계속해서 탐색 방향이 달라지므로 index의 짝수 여부로 어느 방향으로 탐색하는지 판별
 * 발견된 X의 위치를 계산하고 flag에 따라 값 출력
 */
class Q1193_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int X = Integer.parseInt(br.readLine());
        int line = 1;
        int sum = 1;
        while (X > sum) {
            line++;
            sum += line;
        }
        int position = X - sum + line;

        StringBuilder sb = new StringBuilder();
        if ((line%2)==1) {
            sb.append(line - position + 1).append("/").append(position);
        } else sb.append(position).append("/").append(line - position + 1);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}