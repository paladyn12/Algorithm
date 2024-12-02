package BAEKJOON.구현.일반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 10988
 * 문제 이름: 팰린드롬인지 확인하기
 * 문제 링크: https://www.acmicpc.net/problem/10988
 * 풀이: 맨 앞부터 양쪽으로 확인하는 반복문 수행
 */
class Q10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String str = br.readLine();
        int check = 0;

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) check++;
        }

        if (check == 0) System.out.println(1);
        else System.out.println(0);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}