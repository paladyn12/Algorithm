import java.io.*;
import java.util.*;

public class Q2383 {

    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Stair {
        Node point;
        int depth;

        public Stair(Node point, int depth) {
            this.point = point;
            this.depth = depth;
        }
    }
    
    static int N;
    static ArrayList<Node> people;
    static int[][] map;
    static boolean[] visit;
    
    static Stair stair_1;
    static Stair stair_2;

    static int ans;
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = Integer.MAX_VALUE;
            
            N = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            map = new int[N][N];
            stair_1 = null;
            stair_2 = null;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) people.add(new Node(i, j));
                    else if (map[i][j] >= 2) {
                        if (stair_1 == null) stair_1 = new Stair(new Node(i, j), map[i][j]);
                        else stair_2 = new Stair(new Node(i, j), map[i][j]);
                    }
                }
            }

            visit = new boolean[people.size()];
            dfs(0);
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == people.size()) {
            ArrayList<Node> p1 = new ArrayList<>();
            ArrayList<Node> p2 = new ArrayList<>();
            Node person = null;
            for (int i = 0; i < people.size(); i++) {
                person = people.get(i);
                if (visit[i]) {
                    p1.add(person);
                } else {
                    p2.add(person);
                }
            }
            ans = Math.min(ans, Math.max(logic(p1, stair_1), logic(p2, stair_2)));
            return;
        }

        visit[depth] = false;
        dfs(depth + 1);
        visit[depth] = true;
        dfs(depth + 1);
    }

    static int logic(ArrayList<Node> p, Stair stair) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Node person : p) {
            int dist = Math.abs(stair.point.x - person.x) + Math.abs(stair.point.y - person.y);
            pq.offer(dist);
        }

        int[] timeArray = new int[1000];
        int lastTime = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll() + 1;
            while (timeArray[cur] >= 3) cur++;
            for (int i = 0; i < stair.depth; i++) {
                timeArray[cur + i]++;
                lastTime = cur + i;
            }
        }

        return lastTime + 1;
    }
}
