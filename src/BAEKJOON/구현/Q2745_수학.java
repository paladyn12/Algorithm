package BAEKJOON.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 2745
 * 문제 이름: 진법 변환
 * 문제 링크: https://www.acmicpc.net/problem/2745
 * 풀이: 각 자릿수에 대해 진법*자릿수를 더함
 */
class Q2745_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num = st.nextToken();
        int base = Integer.parseInt(st.nextToken());
        int sum = 0;
        int position = num.length()-1;

        //각 자릿수마다 진법의 제곱수를 곱해 sum에 더함
        for (int i = 0; i < num.length(); i++) {
            int n = toNumber(num.charAt(i));
            sum += (int) (Math.pow(base, position) * n);
            position--;
        }

        System.out.println(sum);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static int toNumber(char c) {
        if (c <= 57) return c - 48;
        else return c - 55;
    }
}