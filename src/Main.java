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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int X = Integer.parseInt(br.readLine());
        int line = 1;
        int sum = 1;
        while (X > sum) {
            line++;
            sum += line;
        }
        int position = X - sum + line;

        StringBuilder sb = new StringBuilder();
        if ((line%2)==1) {
            sb.append(line - position + 1).append("/").append(position);
        } else sb.append(position).append("/").append(line - position + 1);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}