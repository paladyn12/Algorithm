import java.util.*;
import java.io.*;

class Q28707_Dijkstra {

    static class Node implements Comparable<Node> {
        int[] nums;
        int cost;
        
        public Node(int[] nums, int cost) {
            this.nums = nums;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int[][] changeCost;
    static Map<String, Integer> minCost = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        changeCost = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(changeCost[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            changeCost[a][b] = Math.min(changeCost[a][b], c);
        }

        bfs(nums);
        
    }

    static void bfs(int[] nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        minCost.put(Arrays.toString(nums), 0);
        pq.offer(new Node(nums, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            String curState = Arrays.toString(cur.nums);
            if (cur.cost > minCost.get(curState)) continue;
            
            if (success(cur.nums)) {
                System.out.print(cur.cost);
                return;
            }

            for (int i = 0; i < cur.nums.length - 1; i++) {
                for (int j = i + 1; j < cur.nums.length; j++) {
                    if (changeCost[i][j] != Integer.MAX_VALUE) {
                        int newCost = cur.cost + changeCost[i][j];
                        int[] copy = Arrays.copyOf(cur.nums, cur.nums.length);
                        int temp = copy[i];
                        copy[i] = copy[j];
                        copy[j] = temp;
                        String nextState = Arrays.toString(copy);
                        
                        if (newCost < minCost.getOrDefault(nextState, Integer.MAX_VALUE)) {
                            minCost.put(nextState, newCost);
                            pq.offer(new Node(copy, newCost));
                        }
                    }
                }
            }
        }
        System.out.print(-1);
        return;
    }

    static boolean success(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) return false;
        }
        return true;
    }
}
