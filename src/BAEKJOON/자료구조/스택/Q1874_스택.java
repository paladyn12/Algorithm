package BAEKJOON.자료구조.스택;

import java.io.*;
import java.util.ArrayList;

/**
 * 문제 번호: 1874
 * 문제 이름: 스택 수열
 * 풀이: 입력값이 stack의 top 보다 큰 경우 전부 더함
 * 더하는 값을 last라는 값을 증가시키며 더해 중복되는 값이 더해지지 않도록 함
 * top보다 작은 수가 입력된 경우 NO 출력
 */
class Q1874_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int last = 1;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (last <= input) {
                while (last <= input) {
                    stack.add(last);
                    last++;
                    sb.append("+\n");
                }
                stack.remove(stack.size()-1);
                sb.append("-\n");
            } else {
                if (stack.get(stack.size()-1) != input) {
                    System.out.println("NO");
                    System.exit(0);
                } else {
                    stack.remove(stack.size()-1);
                    sb.append("-\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
