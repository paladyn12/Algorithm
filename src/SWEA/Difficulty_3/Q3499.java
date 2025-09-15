import java.io.*;
import java.util.*;

public class Q3499 {

    static String[] input;
    static String[] ans;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            input = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) input[i] = st.nextToken();

            ans = new String[N];
            for (int i = 0; i < N; i++) {
                if (N % 2 == 0) {
                    if (i < N / 2) {
                        ans[i * 2] = input[i];
                    } else {
                        ans[(i - N / 2) * 2 + 1] = input[i];
                    }
                } else {
                    if (i <= N / 2) {
                        ans[i * 2] = input[i];
                    } else {
                        ans[(i - N / 2) * 2 - 1] = input[i];
                    }
                }
            }
            for (String s : ans) sb.append(s).append(" ");
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
