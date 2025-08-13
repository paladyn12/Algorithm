import java.util.*;
import java.io.*;

class Q4008 {

    static int max;
    static int min;
    static int[] oper;
    static int[] nums;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            oper = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                oper[i] = Integer.parseInt(st.nextToken());
            }
            nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(nums[0], 1);
            
            sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int result, int depth) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                if (i == 0) dfs(result + nums[depth], depth + 1);
                else if (i == 1) dfs(result - nums[depth], depth + 1);
                else if (i == 2) dfs(result * nums[depth], depth + 1);
                else dfs(result / nums[depth], depth + 1);
                oper[i]++;
            }
        }
    }
}
