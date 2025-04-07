import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

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

        String s = br.readLine();
        int L = s.length(); // 120
        int sum = 0;
        for (int i = 1; i < L; i++) {
            sum += (int) (9 * (i * Math.pow(10, i-1)));
        }
        sum += (int) (L * (Integer.parseInt(s) - Math.pow(10, L - 1) + 1));

        System.out.println(sum);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}