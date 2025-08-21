import java.io.*;
import java.util.*;


public class Q2105 {

	static int ans;
	static int N;
	static int[][] dessert;
	static boolean[] visit;
	static int start_x;
	static int start_y;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = -1;
			N = Integer.parseInt(br.readLine());
			dessert = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					dessert[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit = new boolean[101];
					visit[dessert[i][j]] = true;
					start_x = i;
					start_y = j;
					dfs(i, j, 0, 0);
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int x, int y, int right, int left) {
		if (right > 0 && left > 0 && (right + left) * 2 > ans) {
			// 돌아오는 로직
			int curX = x;
			int curY = y;
			
			HashSet<Integer> set = new HashSet<>();

			boolean flag = true;
			
			for (int i = 0; i < right; i++) {
				curX--;
				curY--;
				if (curX < 0 || curX >= N || curY < 0 || curY >= N) {
					flag = false;
					break;
				}
				if (visit[dessert[curX][curY]] || set.contains(dessert[curX][curY])) {
					flag = false;
					break;
				} else set.add(dessert[curX][curY]);
			}
			
			for (int i = 0; i < left; i++) {
				curX--;
				curY++;
				if (curX == start_x && curY == start_y && flag) {
					ans = Math.max(ans, (left + right) * 2);
				}
				if (curX < 0 || curX >= N || curY < 0 || curY >= N) {
					flag = false;
					break;
				}
				if (visit[dessert[curX][curY]] || set.contains(dessert[curX][curY])) {
					flag = false;
					break;
				} else set.add(dessert[curX][curY]);
			}
		}

		if (x + 1 < N && y + 1 < N && left == 0) {
			if (!visit[dessert[x + 1][y + 1]]) {
				visit[dessert[x + 1][y + 1]] = true;
				dfs(x + 1, y + 1, right + 1, left);
				visit[dessert[x + 1][y + 1]] = false;
			}
		}
		
		if (x + 1 < N && y - 1 >= 0 && right > 0) {
			if (!visit[dessert[x + 1][y - 1]]) {
				visit[dessert[x + 1][y - 1]] = true;
				dfs(x + 1, y - 1, right, left + 1);
				visit[dessert[x + 1][y - 1]] = false;
			}
		}
	}
}
