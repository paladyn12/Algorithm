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
        String string;
        StringBuilder sb = new StringBuilder();
        while ((string = br.readLine()) != null) {
            int[] result = new int[4];
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                result[logic(ch)]++;
            }
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    private static int logic(char ch) {
        if (ch >= 97 && ch <= 122) {
            return 0;
        } else if (ch >= 65 && ch <= 90) {
            return 1;
        } else if (ch >= 48 && ch <= 57) {
            return 2;
        } else if (ch == 32) {
            return 3;
        }
        return 0;
    }
}