package BAEKJOON.자료구조.스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 17298
 * 문제 이름: 오큰수
 * 풀이: 뒤에서부터 값을 조회하며
 * stack의 top보다 값이 작으면 stack에 저장
 * stack의 모든 값 보다 값이 크면 stack을 비우고 값 저장
 */
class Q17298_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer to = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(to.nextToken());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = N-1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.isEmpty()) {
                int last = stack.peekLast();
                if (num < last) {
                    nums[i] = last;
                    stack.addLast(num);
                    break;
                }
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                nums[i] = -1;
                stack.addLast(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}