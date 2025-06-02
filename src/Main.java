import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이 :
 */

class Main {
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