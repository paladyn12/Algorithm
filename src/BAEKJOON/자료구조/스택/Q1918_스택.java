package BAEKJOON.자료구조.스택;

import java.io.*;
import java.util.ArrayDeque;

/**
 * 문제 번호: 1918
 * 문제 이름: 후위 표기식
 * 풀이: 피연산자는 바로 출력하고 연산자는 stack
 * top보다 낮은 우선순위의 연산자가 들어오면 같은 우선순위 연산자 나올 때 까지 pop
 * ) 나오면 ( 나올 때 까지 pop
 */
class Q1918_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String string = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peekLast()) >= priority(ch)) {
                        sb.append(stack.pollLast());
                    }
                    stack.addLast(ch);
                    break;
                case '(':
                    stack.addLast(ch);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peekLast() != '(')
                        sb.append(stack.pollLast());
                    stack.pollLast();
                    break;
                default:
                    sb.append(ch);
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    public static int priority(char operator){
        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}
