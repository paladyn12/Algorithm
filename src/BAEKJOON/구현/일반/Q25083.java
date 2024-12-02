package BAEKJOON.구현.일반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 25083
 * 문제 이름: 새싹
 * 문제 링크: https://www.acmicpc.net/problem/25083
 * 풀이: sb에 새싹 문자열을 append
 */
class Q25083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        sb.append("         ,r'\"7\n");
        sb.append("r`-_   ,'  ,/\n");
        sb.append(" \\. \". L_r'\n");
        sb.append("   `~\\/\n");
        sb.append("      |\n");
        sb.append("      |");
        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}