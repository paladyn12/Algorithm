import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (t1, t2) -> {
            if (t1[1] == t2[1]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });

        int endTime = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (info[i][0] >= endTime) {
                count++;
                endTime = info[i][1];
            }
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

}