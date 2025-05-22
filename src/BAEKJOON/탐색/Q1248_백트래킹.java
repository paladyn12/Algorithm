package BAEKJOON.탐색;

import java.io.*;

/**
 * 문제 번호: 1248
 * 문제 이름: Guess
 * 풀이: dfs 방식으로 탐색하며 array에 값을 넣을 때 마다 matrix의 부호 조건에 맞는지 확인하며 삽입
 */
class Q1248_백트래킹 {

    static int n;
    static char[][] matrix;
    static int[] array;
    static boolean done;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];
        String input = br.readLine();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                matrix[i][j] = input.charAt(idx);
                idx++;
            }
        }
        array = new int[n];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            done = true;
            return;
        }

        for (int i = -10; i <= 10; i++) {

            array[depth] = i;
            if (logic(array, depth, matrix)) {
                // array[depth] = i;
                dfs(depth + 1);
            }
            if (done) break;
        }
    }

    static boolean logic(int[] array, int depth, char[][] matrix) {
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += array[j];
                char op = matrix[i][j];
                if (op == '+' && sum <= 0) return false;
                if (op == '-' && sum >= 0) return false;
                if (op == '0' && sum != 0) return false;
            }
        }
        return true;
    }
}