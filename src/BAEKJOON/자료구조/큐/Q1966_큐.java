import java.util.*;
import java.io.*;

class Paper {
    int order;
    int priority;

    public Paper(int order, int priority) {
        this.order = order;
        this.priority = priority;
    }

}

class Q1966_큐 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayDeque<Paper> dq = new ArrayDeque<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dq.addLast(new Paper(i, Integer.parseInt(st.nextToken())));
            }

            int cnt = 1;
            boolean flag = true;
            while (true) {
                int maxPriority = logic(dq);
                Paper p = dq.pollFirst();
                while (p.priority != maxPriority) {
                    dq.addLast(p);
                    p = dq.pollFirst();
                }
                if (p.order == M) break;
                cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        
    }

    static int logic(ArrayDeque<Paper> dq) {
        int maxPriority = 0;
        for (Paper p : dq) maxPriority = Math.max(maxPriority, p.priority);
        return maxPriority;
    }
}
