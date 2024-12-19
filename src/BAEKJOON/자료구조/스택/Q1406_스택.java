package BAEKJOON.자료구조.스택;

import java.io.*;
import java.util.ArrayDeque;

/**
 * 문제 번호: 1406
 * 문제 이름: 에디터
 * 풀이: 커서를 기준으로 왼쪽 Stack, 오른쪽 Stack으로 나눠 커서의 이동을 양 Stack의 값 교환으로 구현
 */
class Q1406_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String string = br.readLine();
        ArrayDeque<Character> leftStack = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++)
            leftStack.addLast(string.charAt(i));
        ArrayDeque<Character> rightStack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                leftStack.addLast(split[1].charAt(0));
            } else {
                char operation = split[0].charAt(0);
                switch (operation) {
                    case 'L':
                        if (!leftStack.isEmpty()) {
                            rightStack.addFirst(leftStack.removeLast());
                        }
                        break;
                    case 'D':
                        if (!rightStack.isEmpty()) {
                            leftStack.addLast(rightStack.removeFirst());
                        }
                        break;
                    case 'B':
                        if (!leftStack.isEmpty()) {
                            leftStack.removeLast();
                        }
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : leftStack) {
            sb.append(c);
        }
        for (Character c : rightStack) {
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
