import java.util.*;
import java.io.*;


class Q3055_BFS {
	
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
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        Node S = null;
        Node D = null;
        ArrayDeque<Node> dq = new ArrayDeque<>();
        int[][] water = new int[R][C];
        for (int i = 0; i < R; i++) {
        	Arrays.fill(water[i], Integer.MAX_VALUE);
        }
        
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < C; j++) {
        		map[i][j] = input.charAt(j);
        		if (map[i][j] == 'S') {
        			S = new Node(i, j);
        		} else if (map[i][j] == 'D') {
        			D = new Node(i, j);
        		} else if (map[i][j] == '*') {
        			dq.addLast(new Node(i, j));
        			water[i][j] = 0;
        		}
        	}
        }
        
        while (!dq.isEmpty()) {
        	Node cur = dq.pollFirst();
        	for (int d = 0; d < 4; d++) {
        		int nx = cur.x + dx[d];
        		int ny = cur.y + dy[d];
        		if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
        		if (water[nx][ny] == Integer.MAX_VALUE && map[nx][ny] != 'X' && map[nx][ny] != 'D') {
        			water[nx][ny] = water[cur.x][cur.y] + 1;
        			dq.addLast(new Node(nx, ny));
        		}
        	}
        }
        
        int[][] visit = new int[R][C];
        for (int i = 0; i < R; i++) {
        	Arrays.fill(visit[i], -1);
        }
        dq.addLast(S);
        visit[S.x][S.y] = 0;
        while (!dq.isEmpty()) {
        	Node cur = dq.pollFirst();
        	for (int d = 0; d < 4; d++) {
        		int nx = cur.x + dx[d];
        		int ny = cur.y + dy[d];
        		if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
        		if (map[nx][ny] != 'X' && visit[cur.x][cur.y] + 1 < water[nx][ny] && visit[nx][ny] == -1) {
        			visit[nx][ny] = visit[cur.x][cur.y] + 1;
        			dq.addLast(new Node(nx, ny));
        		}
        	}
        }

        if (visit[D.x][D.y] == -1) System.out.print("KAKTUS");
        else System.out.println(visit[D.x][D.y]);
    }
}
