import java.util.*;
import java.io.*;

class Q25501_재귀 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            logic(input, 0, input.length() - 1);
        }

        System.out.print(sb);
    }

    static void logic(String str, int l, int r) {
        if (l >= r) {
            sb.append("1 ").append(l + 1).append("\n");
            return;
        }
        if (str.charAt(l) != str.charAt(r)) {
            sb.append("0 ").append(l + 1).append("\n");
            return;
        } else {
            logic(str, l + 1, r - 1);
        }
    }
}
