import java.util.*;
import java.io.*;

class Q14888_DFS {

    static int N;
    static int[] A;
    static int[] operator = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.print(sb);
    }

    static void dfs(int currentValue, int depth) {
        if (depth == N) {
            max = Math.max(max, currentValue);
            min = Math.min(min, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(currentValue + A[depth], depth + 1);
                        break;
                    case 1:
                        dfs(currentValue - A[depth], depth + 1);
                        break;
                    case 2:
                        dfs(currentValue * A[depth], depth + 1);
                        break;
                    case 3:
                        dfs(currentValue / A[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}