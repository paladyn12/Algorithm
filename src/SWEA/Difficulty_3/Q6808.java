import java.util.*;
import java.io.*;

class Q6808 {

    static int win;
    static int lose;
    static boolean[] visit;

    static int[] in;
    static int[] gyu;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {

            win = 0;
            lose = 0;

            boolean[] check = new boolean[19];
            in = new int[9];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                in[i] = num;
                check[num] = true;
            }

            gyu = new int[9];
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    gyu[idx++] = i;
                }
            }

            visit = new boolean[9];
            dfs(0, 0, 0);
            


            sb.append("#").append(test_case).append(" ").append(lose).append(" ").append(win).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth, int score_g, int score_i) {
        if (depth == 9) {
            if (score_g > score_i) win++;
            else if (score_g < score_i) lose++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (gyu[i] > in[depth]) dfs(depth + 1, score_g + gyu[i] + in[depth], score_i);
                else dfs(depth + 1, score_g, score_i + gyu[i] + in[depth]);
                visit[i] = false;
            }
        }
        
    }
}
