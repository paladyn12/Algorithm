import java.io.*;
import java.util.Arrays;

/**
 * 문제 번호: 10972
 * 문제 이름: 다음 순열
 * 풀이:
 */
class Main {

    static int N;
    static boolean[] visit;
    static int[] input;
    static int[] array;

    static boolean next = false;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visit = new boolean[N];
        array = new int[N];

        logic(0);

        if (next) System.out.println(-1);
        else System.out.println(sb);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void logic(int depth) {
        if (depth == N) {
            if (next) {
                for (int i : array) {
                    sb.append(i).append(" ");
                }
                next = false;
            }
            else {
                if (Arrays.equals(array, input)) next = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = i + 1;
                logic(depth + 1);
            }
        }

    }
}