import java.io.*;
import java.util.*;

class FromTo {
    int from;
    int to;
    public FromTo(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class Q16928_BFS {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        FromTo[] ladders = new FromTo[N];
        FromTo[] snakes = new FromTo[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladders[i] = new FromTo(from, to);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snakes[i] = new FromTo(from, to);
        }

        int[] dp = new int[101];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        dp[1] = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(1);
        while (!dq.isEmpty()) {
            boolean cont = false;
            int cur = dq.pollFirst();
            for (int i = 0; i < N; i++) {
                if (ladders[i].from == cur) cont = true;
            }
            for (int i = 0; i < M; i++) {
                if (snakes[i].from == cur) cont = true;
            }
            if (cont) continue;
            for (int i = 1; i <= 6; i++) {
                if (cur + i > 100) continue;
                if (dp[cur + i] > dp[cur] + 1) {
                    dp[cur + i] = dp[cur] + 1;
                    dq.addLast(cur + i);
                    for (int j = 0; j < N; j++) {
                        if (ladders[j].from == cur + i) {
                            if (dp[ladders[j].to] > dp[cur + i]) {
                                dp[ladders[j].to] = dp[cur + i];
                                dq.addLast(ladders[j].to);
                            }
                        }
                    }
                    for (int j = 0; j < M; j++) {
                        if (snakes[j].from == cur + i) {
                            if (dp[snakes[j].to] > dp[cur + i]) {
                                dp[snakes[j].to] = dp[cur + i];
                                dq.addLast(snakes[j].to);
                            }
                        }
                    }
                }
            }
        } 

        for (int i = 1; i <= 100; i++) {
            //System.out.println("i: " + i + ", dp[i]: " + dp[i]);
        }
        
        System.out.print(dp[100]);
    }
}
