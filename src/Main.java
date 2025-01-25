import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (N == 0) sb.append(0);
        else {
            while (N != 0) {
                if (N % -2 == 0) {
                    N /= -2;
                    sb.append(0);
                } else {
                    N -= 1;
                    N /= -2;
                    sb.append(1);
                }
            }
        }
        sb.reverse();

        System.out.println(sb);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
