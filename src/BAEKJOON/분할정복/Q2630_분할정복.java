import java.io.*;
import java.util.*;

public class Q2630_분할정복 {

    static int N;
    static int[][] paper;
    static int blue = 0;
    static int white = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        logic(0, 0, N);

        System.out.print(white + "\n" + blue);
    }

    static void logic(int x, int y, int size) {
        int start = paper[x][y];
        boolean success = true;
        for (int i = 0; i < size; i++) {
            if (!success) break;
            for (int j = 0; j < size; j++) {
                if (paper[x + i][y + j] != start) {
                    success = false;
                    break;
                }
            }
        }
        if (success) {
            if (start == 1) blue++;
            else white++;
        } else {
            int half = size / 2;
            logic(x, y, half);
            logic(x + half, y, half);
            logic(x, y + half, half);
            logic(x + half, y + half, half);
        }
    }
}
