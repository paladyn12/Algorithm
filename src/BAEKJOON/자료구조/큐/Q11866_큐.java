import java.util.*;
import java.io.*;

class Q11866_큐 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(dq.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                dq.addLast(dq.pollFirst());
            }
            sb.append(dq.pollFirst()).append(", ");
        }
        sb.append(dq.pollFirst()).append(">");
        System.out.print(sb);
    }
}
