package BAEKJOON.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 10807
 * 문제 이름: 개수 세기
 * 문제 링크: https://www.acmicpc.net/problem/10807
 * 풀이: 찾으려는 정수를 저장해 같은 값이 나올 때마다 count++
 */
class Q10807_일차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int v = Integer.parseInt(br.readLine());
        int count = 0;

        for (String num : nums) {
            if (v == Integer.parseInt(num)) count++;
        }
        System.out.print(count);
        br.close();
    }
}