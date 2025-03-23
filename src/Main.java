import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {

    static int N;
    static int M;
    static int[] array;
    static int[] nums;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[M];
        nums = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    public static void dfs(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            array[depth] = nums[i];
            dfs(depth + 1);
//            if (!visit[i]) {
//                array[depth] = nums[i];
//                visit[i] = true;
//                dfs(depth + 1);
//            }
//            visit[i] = false;
        }
    }
}