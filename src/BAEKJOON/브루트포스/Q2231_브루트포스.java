package BAEKJOON.브루트포스;

import java.io.*;
/**
 * 문제 번호: 2231
 * 문제 이름: 브루트포스
 * 문제 링크: https://www.acmicpc.net/problem/2231
 * 풀이: 수를 문자열로 바꿔 각 자릿수별로 sum에 더해나감
 */
class Q2231_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String nStr = br.readLine();
        int n = Integer.parseInt(nStr);
        int result = 0;

        for (int i = n-nStr.length()*9; i <= n; i++) {
            if (logic(i) == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

    private static int logic(int i) {
        int sum = i;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}