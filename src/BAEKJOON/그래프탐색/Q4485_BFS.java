import java.io.*;
import java.util.*;

public class Q4485_BFS {
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = 1;
        while (true) {
        	
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] distance = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[0][0] = cave[0][0];
            ArrayDeque<Node> dq = new ArrayDeque<>();
            dq.addLast(new Node(0, 0));
            while (!dq.isEmpty()) {
            	Node cur = dq.pollFirst();
            	for (int d = 0; d < 4; d++) {
            		int nx = cur.x + dx[d];
            		int ny = cur.y + dy[d];
            		if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            		if (distance[nx][ny] > distance[cur.x][cur.y] + cave[nx][ny]) {
            			distance[nx][ny] = distance[cur.x][cur.y] + cave[nx][ny];
            			dq.addLast(new Node(nx, ny));
            		}
            	}
            }
            
            sb.append("Problem ").append(test_case).append(": ").append(distance[N-1][N-1]).append("\n");
            test_case++;
        }
        
        System.out.print(sb);
    }
}
