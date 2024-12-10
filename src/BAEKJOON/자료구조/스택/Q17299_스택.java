package BAEKJOON.자료구조.스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제 번호: 17299
 * 문제 이름: 오등큰수
 * 문제 링크: https://www.acmicpc.net/problem/17299
 * 풀이: 수의 빈도를 계산하여 각 수의 빈도를 오큰수 문제처럼 비교
 * 단, 비교 후 값 저장 시 빈도가 아닌 빈도를 체크한 값을 저장
 */
class Q17299_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] count = new int[1000001];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            count[nums[i]]++;
        }

        for (int i = N-1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.isEmpty()) {
                int last = stack.peekLast();
                if (count[num] < count[last]) {
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
