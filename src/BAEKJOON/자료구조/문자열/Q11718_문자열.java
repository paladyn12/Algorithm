package BAEKJOON.자료구조.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호: 11718
 * 문제 이름: 그대로 출력하기
 * 풀이: 다음 문자열이 없을 때 null을 반환하도록 while문 작성
 */
class Q11718_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(sb);
        br.close();
    }
}