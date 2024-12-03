package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 9063
 * 문제 이름: 대지
 * 문제 링크: https://www.acmicpc.net/problem/9063
 * 풀이: 들어오는 최대 최소 x, y값을 저장해 넓이 계산
 */
class Q9063_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());

        int minX = Integer.MAX_VALUE;
        int maxX =Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY =Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
            minY = Math.min(y, minY);
            maxY = Math.max(y, maxY);
        }

        int result = (maxX-minX)*(maxY-minY);
        bw.write(String.valueOf(result));
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}