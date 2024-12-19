package BAEKJOON.시간복잡도;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 24313
 * 문제 이름: 알고리즘 수업 - 점근적 표기 1
 * 풀이: c가 fn의 계수보다 크거나 같아야 하고
 * n0에 대해 c*n0이 f(n0)보다 크거나 같아야함
 */
class Q24313_시간복잡도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if (c >= a1 && c*n0 >= (a1*n0+a2)) System.out.println(1);
        else System.out.println(0);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}