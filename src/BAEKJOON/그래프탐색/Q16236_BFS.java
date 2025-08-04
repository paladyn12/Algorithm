import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Fish implements Comparable<Fish> {
    Point point;
    int distance;
    public Fish(int x, int y, int distance) {
        point = new Point(x, y);
        this.distance = distance;
    }

    @Override
    public int compareTo(Fish f) {
        if (this.distance != f.distance) return Integer.compare(this.distance, f.distance);
        else if (this.point.x != f.point.x) return Integer.compare(this.point.x, f.point.x);
        else return Integer.compare(this.point.y, f.point.y);
    }
}

class Shark {
    Point point;
    int size = 2;
    int cnt = 0;

    public Shark(int x, int y) {
        point = new Point(x, y);
    }

    public void eat(Point fish) {
        if (++cnt == size) {
            size++;
            cnt = 0;
        }
        point.x = fish.x;
        point.y = fish.y;
    }
}

class Q16236_BFS {

    static int[][] ocean;
    static int[][] visit;
    static int N;
    static Shark shark;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0 ,-1};
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ocean = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
            	ocean[i][j] = Integer.parseInt(st.nextToken());
                if (ocean[i][j] == 9) {
                    shark = new Shark(i, j);
                    ocean[i][j] = 0;
                }
            }
        }

        Point fish = bfs(shark);
        while (fish != null) {
            shark.eat(fish);
            fish = bfs(shark);
        }

        System.out.print(result);
    }

    static Point bfs(Shark shark) {
        ArrayDeque<Point> dq = new ArrayDeque<>();
        PriorityQueue<Fish> fishes = new PriorityQueue<Fish>();
        visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], -1);
        }
        dq.addLast(shark.point);
        visit[shark.point.x][shark.point.y] = 0;

        while (!dq.isEmpty()) {

            Point cur = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (ocean[nx][ny] <= shark.size && visit[nx][ny] == -1) {
                    visit[nx][ny] = visit[cur.x][cur.y] + 1;
                    if (ocean[nx][ny] < shark.size && ocean[nx][ny] != 0) fishes.offer(new Fish(nx, ny, visit[nx][ny]));
                    dq.addLast(new Point(nx, ny));
                }
            }
            
        }

        if (fishes.isEmpty()) return null;

        Fish f = fishes.poll();
        result += f.distance;
        ocean[f.point.x][f.point.y] = 0;
        return f.point;
        
    }

}
