package BAEKJOON.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 3003
 * 문제 이름: 킹, 퀸, 룩, 비숍, 나이트, 폰
 * 문제 링크: https://www.acmicpc.net/problem/3003
 * 풀이: 값을 입력받고 각각 필요한 값에서 입력 값을 뺌
 */
class Q3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int rook = Integer.parseInt(st.nextToken());
        int bishop = Integer.parseInt(st.nextToken());
        int knight = Integer.parseInt(st.nextToken());
        int pawn = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(1-king).append(" ");
        sb.append(1-queen).append(" ");
        sb.append(2-rook).append(" ");
        sb.append(2-bishop).append(" ");
        sb.append(2-knight).append(" ");
        sb.append(8-pawn).append(" ");

        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}