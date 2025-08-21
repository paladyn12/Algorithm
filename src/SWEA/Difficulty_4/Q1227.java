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

public class Q1227 {

	static boolean[][] visit;
	static int N;
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayDeque<Node> dq = new ArrayDeque<>();
		Node goal = null;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			
			N = 100;
			map = new int[N][N];
			visit = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					if (map[i][j] == 2) {
						dq.addLast(new Node(i, j));
						visit[i][j] = true;
					} else if (map[i][j] == 3) {
						goal = new Node(i, j);
						map[i][j] = 0;
					}
				}
			}
			
			while (!dq.isEmpty()) {
				Node cur = dq.pollFirst();
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (!visit[nx][ny] && map[nx][ny] == 0) {
						visit[nx][ny] = true;
						dq.addLast(new Node(nx, ny));
					}
				}
			}
			
			int ans = visit[goal.x][goal.y] ? 1 : 0;
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
