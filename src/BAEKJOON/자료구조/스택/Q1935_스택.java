package BAEKJOON.자료구조.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 문제 번호: 1935
 * 문제 이름: 후위 표기식2
 * 문제 링크: https://www.acmicpc.net/problem/1935
 * 풀이: A, B, C는 각각 65를 빼면 0, 1, 2가 되므로 문자 갯수만큼 배열을 만들어 문자에 대한 대응값 저장
 * 연산자를 만나면 stack의 두 수를 뽑아 연산하여 stack에 저장
 * 최종적으로 stack에 남은 값 출력
 */
class Q1935_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        String operate = br.readLine();
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < operate.length(); i++) {
            char ch = operate.charAt(i);
            double a;
            double b;
            switch (ch) {
                case '+':
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b+a);
                    break;
                case '-':
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b-a);
                    break;
                case '*':
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b*a);
                    break;
                case '/':
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b/a);
                    break;
                default:
                    stack.addLast((double) nums[ch-65]);
            }
        }
        System.out.printf("%.2f", stack.peek());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}