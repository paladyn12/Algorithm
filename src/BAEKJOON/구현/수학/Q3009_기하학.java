package BAEKJOON.구현.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 3009
 * 문제 이름: 네 번째 점
 * 풀이: 입력된 값 중 1번만 나온 x, y 값을 반환
 */
class Q3009_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int x4;
        int y4;

        if (x1==x2) x4 = x3;
        else if (x1==x3) x4 = x2;
        else x4 = x1;

        if (y1==y2) y4 = y3;
        else if (y1==y3) y4 = y2;
        else y4 = y1;

        StringBuilder sb = new StringBuilder();
        sb.append(x4).append(" ").append(y4);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}