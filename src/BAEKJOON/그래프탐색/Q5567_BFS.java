import java.io.*;
import java.util.*;

public class Q5567_BFS {

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph;

    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int result = 0;

        int[] visit = new int[N + 1];
        Arrays.fill(visit, -1);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(1);
        visit[1] = 0;
        while (!dq.isEmpty()) {
            int curIdx = dq.pollFirst();
            int curCnt = visit[curIdx];

            for (int i = 0; i < graph.get(curIdx).size(); i++) {
                int next = graph.get(curIdx).get(i);
                if (visit[next] == -1) {
                    visit[next] = curCnt + 1;
                    result++;
                    // 찾은 노드가 상근의 친구인 경우에만 DQ에 넣기
                    if (curCnt == 0) dq.addLast(next);
                }
            }
            
        }
        System.out.print(result);
    }
}
