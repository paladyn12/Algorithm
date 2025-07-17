import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Q11729 {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);

        System.out.println(cnt);
        System.out.println(sb);
    }

    static void hanoi(int N, int from, int to, int via) {
        if (N == 1) {
            cnt++;
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(N-1, from, via, to);
            hanoi(1, from, to, via);
            hanoi(N-1, via, to, from);
        }
    }
}