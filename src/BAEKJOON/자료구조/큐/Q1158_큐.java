package BAEKJOON.자료구조.큐;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1158
 * 문제 이름: 요세푸스 문제
 * 문제 링크: https://www.acmicpc.net/problem/1158
 * 풀이: K 배수만큼 Queue에서 맨 앞의 수를 맨 뒤로 보냄
 */
class Q1158_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> people = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (!people.isEmpty()) {
            index = (index + K - 1) % people.size();
            sb.append(people.remove(index));
            if (people.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}