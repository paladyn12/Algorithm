
import java.io.*;
import java.util.*;

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q1249 {

	static int[][] visit;
	static int N;
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(visit[i], -1);
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			ArrayDeque<Node> dq = new ArrayDeque<>();
			dq.addLast(new Node(0, 0));
			visit[0][0] = map[0][0];
			while (!dq.isEmpty()) {
				Node cur = dq.pollFirst();
				if (cur.x == N - 1 && cur.y == N - 1) break;
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (visit[nx][ny] == -1) {
						visit[nx][ny] = visit[cur.x][cur.y] + map[nx][ny];
						dq.addLast(new Node(nx, ny));
					}
				}
			}
			
			
			sb.append("#").append(test_case).append(" ").append(visit[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
}
