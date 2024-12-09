package BAEKJOON.자료구조.큐;

import java.io.*;
import java.util.ArrayList;

/**
 * 문제 번호: 10845
 * 문제 이름: 큐
 * 문제 링크: https://www.acmicpc.net/problem/10845
 * 풀이: 큐 구현
 */
class Q10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> stack = new ArrayList();
        int size = 0;
        int top = -1;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                stack.add(Integer.parseInt(split[1]));
                size++;
                top++;
            } else {
                String operation = split[0];
                switch (operation) {
                    case "pop":
                        if (size >= 1) {
                            size--;
                            top--;
                            sb.append(stack.remove(0)).append("\n");
                        }
                        else sb.append(-1).append("\n");
                        break;
                    case "size":
                        sb.append(size).append("\n");
                        break;
                    case "empty":
                        if (size == 0) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "front":
                        if(top >= 0) sb.append(stack.get(0)).append("\n");
                        else sb.append(-1).append("\n");
                        break;
                    case "back":
                        if(top >= 0) sb.append(stack.get(top)).append("\n");
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
