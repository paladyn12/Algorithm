import java.io.*;
import java.util.*;


public class Q1861 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] room;
	static int[][] result;
	static int N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	int ans_number = 0;
        	int ans_cnt = 0;
        	
        	N = Integer.parseInt(br.readLine());
        	room = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < N; j++) {
        			room[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
            
        	result = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		Arrays.fill(result[i], -1);
        	}
        	
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			int n = find(i, j); // (i, j) 에서 갈 수 있는 단계 수
        			if (n > ans_cnt) {
        				ans_cnt = n;
        				ans_number = room[i][j];
        			} else if (n == ans_cnt) {
        				ans_number = Math.min(ans_number, room[i][j]);
        			}

        		}
        	}
            
            //print(result);
        	
        	sb.append("#").append(test_case).append(" ").append(ans_number).append(" ").append(ans_cnt + 1).append("\n");
        }
        System.out.print(sb);
	}
	
	// result[x][y] != -1 이면 그 값 그대로 반환
	// 아니면 사방으로 +1 높은게 있나 보고 있다면 return result[nx][ny] + 1
	// 없다면 return 0
	static int find(int x, int y) {
		if (result[x][y] != -1) return result[x][y];
		else {
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (room[nx][ny] == room[x][y] + 1) {
					result[x][y] = find(nx, ny) + 1;
                    return result[x][y];
				}
			}
		}

        result[x][y] = 0;
		return result[x][y];
	}

    static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
