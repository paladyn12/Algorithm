package BAEKJOON.자료구조.덱;

import java.io.*;
import java.util.ArrayList;

/**
 * 문제 번호: 10866
 * 문제 이름: 덱
 * 문제 링크: https://www.acmicpc.net/problem/10866
 * 풀이: 덱 기능 구현
 */
class Q10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> deque = new ArrayList<>();
        int size = 0;
        int top = -1;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                if (split[0].equals("push_back")) {
                    deque.add(Integer.parseInt(split[1]));
                    size++;
                    top++;
                } else {
                    deque.add(0, Integer.parseInt(split[1]));
                    size++;
                    top++;
                }
            } else {
                String operation = split[0];
                switch (operation) {
                    case "pop_front":
                        if (size >= 1) {
                            size--;
                            top--;
                            sb.append(deque.remove(0)).append("\n");
                        }
                        else sb.append(-1).append("\n");
                        break;
                    case "pop_back":
                        if (size >= 1) {
                            size--;
                            sb.append(deque.remove(top--)).append("\n");
                        }
                        else sb.append(-1).append("\n");
                        break;
                    case "size":
                        sb.append(size).append("\n");
                        break;
                    case "empty":
                        if (deque.isEmpty()) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "front":
                        if (size > 0) sb.append(deque.get(0)).append("\n");
                        else sb.append(-1).append("\n");
                        break;
                    case "back":
                        if(top >= 0) sb.append(deque.get(top)).append("\n");
                        else sb.append(-1).append("\n");
                        break;
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