import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이 :
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int wrong = Integer.parseInt(br.readLine());
        boolean[] error = new boolean[10];
        if (wrong != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < wrong; i++) {
                error[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int result = Math.abs(100 - N);

        for (int i = 0; i <= 999999; i++) {

            boolean next = false;
            int length = 0;
            int n = i;

            if (n == 0) {
                if (!error[0]) {
                    length = 1;
                } else {
                    next = true;
                }
            }

            while (n > 0) {
                if (error[n % 10]) {
                    next = true;
                    break;
                }
                length++;
                n /= 10;
            }

            if (!next) {
                // 결과 업데이트
                result = Math.min(result, length + Math.abs(N - i));
            }
        }


        System.out.println(result);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}