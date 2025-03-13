package BAEKJOON.브루트포스;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 문제 번호: 2309
 * 문제 이름: 일곱 난쟁이
 * 풀이: Array에 키를 저장하고 제외시킬 2개의 수를 찾는 반복문을 돌림
 */
class Q2309_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int[] heights = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            heights[i] = num;
        }

        int ex1 = 0;
        int ex2 = 0;
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {

                if (sum - heights[i] - heights[j] == 100) {
                    ex1 = i;
                    ex2 = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != ex1 && i != ex2) {
                result.add(heights[i]);
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        for (Integer i : result) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}