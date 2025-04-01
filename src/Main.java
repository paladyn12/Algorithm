import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    static int[] position;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        position = new int[N];

        dfs(0);
        System.out.println(count);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    public static void dfs(int depth) {

        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            position[depth] = i;
            if (possibility(depth)) {
                dfs(depth + 1);
            }

        }
    }

    private static boolean possibility(int depth) {
        for (int i = 0; i < depth; i++) {

            if (position[i] == position[depth]) return false;
            if (Math.abs(depth - i) == Math.abs(position[depth] - position[i])) return false;

        }
        return true;
    }
}