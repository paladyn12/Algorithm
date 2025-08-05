import java.util.*;
import java.io.*;

class Q10250_기본문제 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            String result = "" + ((N + H - 1) % H + 1);
            if ((N + H - 1) / H < 10) {
                result += "0" + (N + H - 1) / H;
            } else {
                result += ((N + H - 1) / H);
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
