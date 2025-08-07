import java.io.*;
import java.util.*;

public class Q1325_BFS {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }
        
        ArrayDeque<Integer> dq;
        int[] cntArray = new int[N + 1];
        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {

            boolean[] visit = new boolean[N + 1];
            int cnt = 1;
            dq = new ArrayDeque<>();
            dq.addLast(i);
            visit[i] = true;
            
            //System.out.println("start idx = " + i);
            
            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();

                //System.out.println("current idx = " + cur);
                for (int j = 0; j < graph.get(cur).size(); j++) {
                    int next = graph.get(cur).get(j);
                    if (!visit[next]) {
                        visit[next] = true;
                        cnt++;
                        dq.addLast(next);
                    }
                }
            }
            cntArray[i] = cnt;
            maxCnt = Math.max(maxCnt, cnt);
        }
        //System.out.println(Arrays.toString(cntArray) + " " + maxCnt);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cntArray[i] == maxCnt) sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
