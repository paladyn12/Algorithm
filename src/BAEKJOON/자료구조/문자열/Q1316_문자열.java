package BAEKJOON.자료구조.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 문제 번호: 1316
 * 문제 이름: 그룹 단어 체커
 * 문제 링크: https://www.acmicpc.net/problem/1316
 * 풀이: 문자 리스트에 없던 문자를 만나면 계속 이어지는 동안 넣지 않고 끊겼을 때 넣음
 */
class Q1316_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Character> chars = new HashSet<>();
            String str = br.readLine();
            boolean isFlag = true;

            for (int j = 0; j < str.length(); j++) {
                if (!chars.contains(str.charAt(j))) {
                    if (j < str.length()-1) {
                        if (str.charAt(j) != str.charAt(j+1)) {
                            chars.add(str.charAt(j));
                        }
                    }
                } else isFlag = false;
            }

            if (isFlag) count++;
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}