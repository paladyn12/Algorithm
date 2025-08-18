import java.io.*;
import java.util.*;

public class Q2819 {

	static HashSet<Integer> set;
	static int[][] numbers = new int[4][4];
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			set = new HashSet<>();

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					numbers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, "");
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(set.size()).append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int x, int y, String num) {
		if (num.length() == 7) {
			set.add(Integer.parseInt(num));
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			dfs(nx, ny, num + numbers[nx][ny]);
		}
	}
}
