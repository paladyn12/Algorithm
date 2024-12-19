package BAEKJOON.자료구조.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 2743
 * 문제 이름: 단어 길이 재기
 * 풀이: length() 사용
 */
class Q2743_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String str = br.readLine();
        System.out.println(str.length());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}