import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q21736_BFS {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayDeque<Point> dq = new ArrayDeque<>();

        char[][] school = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                school[i][j] = input.charAt(j);
                if (school[i][j] == 'I') {
                    dq.addLast(new Point(i, j));
                    school[i][j] = 'X';
                }
            }
        }

        int cnt = 0;
        while (!dq.isEmpty()) {
            Point cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (school[nx][ny] == 'X') continue;
                else {
                    if (school[nx][ny] == 'P') cnt++;
                    school[nx][ny] = 'X';
                    dq.addLast(new Point(nx, ny));
                }
            }
        }

        if (cnt == 0) System.out.print("TT");
        else System.out.print(cnt);
    }
}
