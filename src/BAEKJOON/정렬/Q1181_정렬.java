package BAEKJOON.정렬;

import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 1181
 * 문제 이름: 단어 정렬
 * 문제 링크: https://www.acmicpc.net/problem/1181
 * 풀이: 단어들을 String[] 배열에 넣어 길이를 기준으로 sort
 */
class Q1181_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length());
        }));


        StringBuilder sb = new StringBuilder();
        sb.append(strings[0]).append("\n");
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].equals(strings[i - 1])) {continue;}
            sb.append(strings[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}