import java.io.*;
import java.util.*;

public class Q10830_분할정복 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = logic(matrix, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] logic(int[][] mat, long b) {
        if (b == 1) {
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) temp[i][j] = mat[i][j];
            }
            return temp;
        } else if (b == 2) {
            return multi(mat, mat);
        }
        if (b % 2 == 0) return logic(multi(mat, mat), b/2);
        else return multi(logic(multi(mat, mat), b/2), mat);
    }

    static int[][] multi(int[][] mat1, int[][] mat2) {
        int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = 0;
                    for (int k = 0; k < N; k++) {
                        sum += mat1[i][k] * mat2[k][j];
                    }
                    temp[i][j] = sum % 1000;
                }
            }
        return temp;
    }
}
