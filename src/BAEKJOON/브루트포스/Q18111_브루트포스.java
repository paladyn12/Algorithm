import java.io.*;
import java.util.*;

public class Q18111_브루트포스 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        int height = 0;
        
        for (int h = 0; h <= 256; h++) {
            int time = 0;
            int needBlock = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (h <= ground[i][j]) {
                        int temp = ground[i][j] - h;
                        time += 2 * temp;
                        needBlock += temp;
                    } else {
                        int temp = h - ground[i][j];
                        time += temp;
                        needBlock -= temp;
                    }
                }
            }
            if (needBlock + B < 0) continue;
            if (time <= result) {
                result = time;
                height = h;
            }
        }

        System.out.print(result + " " + height);
    }
}
