import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int n = Integer.parseInt(br.readLine());
        int index = 0;

        for (int i = 666; true; i++) {
            int count = 0;
            int I = i;
            while (I > 0) {
                if (I % 10 == 6) count++;
                else count = 0;
                I /= 10;
                if (count == 3) {
                    index++;
                    break;
                }
            }
            if (index == n) {
                System.out.println(i);
                break;
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }

}