package GOORM.자료구조;

import java.io.*;
import java.util.*;

class 뒤통수가뜨거워 {
    /**
     * stack에 내림차순으로 이어진 수들을 저장하여 매 반복마다 그 개수를 출력하는 문제
     * 현재 신선을 볼 수 있는 신선의 수는 stack에 들어있는 신선의 수 (내림차순으로 이어져 있어야 그 신선들이 현재 신선을 볼 수 있음)
     * stack을 선언
     * 수가 내림차순으로 이어지면 stack에 넣고 들어온 값이 stack top보다 크면 pop
     * stack top 보다 큰 값 입력 : 다음 봉우리 높이가 현재 봉우리보다 높음
     */
    public static void main(String[] args) throws IOException {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(input[i]);
        }

        // 스택
        Stack<Integer> stack = new Stack<>();

        // 각 봉우리를 돌며 그 봉우리의 신선을 볼 수 있는 신선의 수 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // stack의 크기 : 현재 봉우리의 신선을 볼 수 있는 신선의 수
            sb.append(stack.size()).append(" ");

            // 더 큰 값이 들어옴 : 다음 봉우리의 높이가 더 큼
            // 내림차순 유지를 위해 입력값보다 작은 값들은 pop
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }

            // 현재 신선을 스택에 추가
            stack.push(i);
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}