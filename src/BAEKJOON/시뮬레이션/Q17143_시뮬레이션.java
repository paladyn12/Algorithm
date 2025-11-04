import java.util.*;
import java.io.*;

class Q17143_시뮬레이션 {

    static class Shark {
        int x;
        int y;
        int speed;
        int dir;
        int size;
        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }

    static int R;
    static int C;
    static int M;
    static Shark[][] ocean;
    static ArrayList<Shark> sharks = new ArrayList<>();
    static ArrayList<Shark> removedSharks;

    static int[] dx = new int[]{0, -1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 0, 1, -1};

    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ocean = new Shark[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            sharks.add(shark);
            ocean[r][c] = shark;
        }

        start();

        System.out.print(ans);
    }

    // 0 ~ C-1 까지 시뮬레이션 수행
    static void start() {
        for (int i = 0; i < C; i++) {
            simulation(i);
        }
    }

    static void simulation(int col) {
        for (int i = 0; i < R; i++) {
            if (ocean[i][col] != null) {
                ans += ocean[i][col].size;
                sharks.remove(ocean[i][col]);
                break;
            }
        }

        ocean = new Shark[R][C];
        removedSharks = new ArrayList<>();
        for (Shark shark : sharks) {
            move(shark);
        }
        
        for (Shark removedShark : removedSharks) {
            sharks.remove(removedShark);
        }
    }

    static void move(Shark shark) {
        for (int i = 0; i < shark.speed; i++) {
            int nx = shark.x + dx[shark.dir];
            int ny = shark.y + dy[shark.dir];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                shark.dir = turn(shark.dir);
                i--;
            } else {
                shark.x = nx;
                shark.y = ny;
            }
        }

        if (ocean[shark.x][shark.y] == null) {
            ocean[shark.x][shark.y] = shark;
        } else if (ocean[shark.x][shark.y].size > shark.size) {
            removedSharks.add(shark);
        } else {
            removedSharks.add(ocean[shark.x][shark.y]);
            ocean[shark.x][shark.y] = shark;
        } 
    }

    static int turn(int dir) {
        if (dir == 1) return 2;
        if (dir == 2) return 1;
        if (dir == 3) return 4;
        if (dir == 4) return 3;
        return 0;
    }
}
