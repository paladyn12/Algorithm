import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Q15686_브루트포스 {

    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Node> houses = new ArrayList<>();
    static ArrayList<Node> chickens = new ArrayList<>();
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new Node(i, j));
                if (map[i][j] == 2) chickens.add(new Node(i, j));
            }
        }

        visit = new boolean[chickens.size()];
        bfs(0, 0);
        System.out.print(ans);
    }

    static void bfs(int start, int depth) {
        if (depth == M) {
            ans = Math.min(ans, calc());
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            visit[i] = true;
            bfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    static int calc() {
        int sum = 0;
        ArrayList<Node> pickedChicken = new ArrayList<>();
        for (int i = 0; i < chickens.size(); i++) {
            if (visit[i]) pickedChicken.add(chickens.get(i));
        }
        for (Node house : houses) {
            int min = Integer.MAX_VALUE;
            for (Node chicken : pickedChicken) {
                min = Math.min(min, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
            }
            sum += min;
        }
        return sum;
    }
}
