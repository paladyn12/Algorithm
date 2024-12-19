package BAEKJOON.자료구조.스택;

import java.io.*;
import java.util.ArrayDeque;

/**
 * 문제 번호: 17413
 * 문제 이름: 단어 뒤집기 2
 * 풀이: <부터 >까지는 문자열을 뒤집지 않는 상태이므로 SB에 바로 넣음
 * 그 외엔 Stack에 넣고 공백이나 <를 만나면 Stack의 값을 꺼내 SB에 넣음
 */
class Q17413_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String S = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean pushing = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (pushing) {
                if (S.charAt(i) != ' ' && S.charAt(i) != '<') {
                    stack.addLast(S.charAt(i));
                } else if (S.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.removeLast());
                    }
                    sb.append(' ');
                } else if (S.charAt(i) == '<') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.removeLast());
                    }
                    pushing = false;
                    sb.append("<");
                }
            } else {
                if (S.charAt(i) != '>') sb.append(S.charAt(i));
                else {
                    sb.append(">");
                    pushing = true;
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}