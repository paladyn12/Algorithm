import java.util.*;
import java.io.*;

class Q11660_다이나믹프로그래밍 {

    static int[][] array;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken()) + array[i-1][j] + array[i][j-1] - array[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(array[x2][y2] - array[x1 - 1][y2] - array[x2][y1 - 1] + array[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
