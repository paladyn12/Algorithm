import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        array[0] = 0;
        array[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (i % 6 == 0) {
                array[i] = Math.min(array[i-1], Math.min(array[i/3], array[i/2])) + 1;
            } else if (i % 3 == 0) {
                array[i] = Math.min(array[i/3], array[i-1]) + 1;
            } else if (i % 2 == 0) {
                array[i] = Math.min(array[i/2], array[i-1]) + 1;
            } else array[i] = array[i-1] + 1;
        }

        System.out.println(array[N]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}