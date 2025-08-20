import java.util.*;
import java.io.*;

class Q12851_BFS {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if (N == K) {
        	System.out.println(0);
        	System.out.println(1);
        	System.exit(0);
        }
        
        int[] visit = new int[100001];
        Arrays.fill(visit, -1);
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(N);
        visit[N] = 0;
        
        int cnt = 0;
        int minDistance = -1;
        while (!dq.isEmpty()) {
        	int cur = dq.pollFirst();
        	
        	if (minDistance != -1 && visit[cur] >= minDistance) continue;
        	
        	if (cur - 1 >= 0) {
        		int next = cur - 1;
        		if (next == K) {
        			if (minDistance == -1) minDistance = visit[cur] + 1;
        			if (minDistance == visit[cur] + 1) cnt++;
        		} else if (visit[next] == -1) {
        			visit[next] = visit[cur] + 1;
        			dq.addLast(next);
        		} else if (visit[next] == visit[cur] + 1) {
        			dq.addLast(next);
        		}
        	}
        	if (cur + 1 <= 100000) {
        		int next = cur + 1;
        		if (next == K) {
        			if (minDistance == -1) minDistance = visit[cur] + 1;
        			if (minDistance == visit[cur] + 1) cnt++;
        		} else if (visit[next] == -1) {
        			visit[next] = visit[cur] + 1;
        			dq.addLast(next);
        		} else if (visit[next] == visit[cur] + 1) {
        			dq.addLast(next);
        		}
        	}
        	if (cur * 2 <= 100000) {
        		int next = cur * 2;
        		if (next == K) {
        			if (minDistance == -1) minDistance = visit[cur] + 1;
        			if (minDistance == visit[cur] + 1) cnt++;
        		} else if (visit[next] == -1) {
        			visit[next] = visit[cur] + 1;
        			dq.addLast(next);
        		} else if (visit[next] == visit[cur] + 1) {
        			dq.addLast(next);
        		}
        	}
       	}
        System.out.println(minDistance);
        System.out.println(cnt);
    }
}
