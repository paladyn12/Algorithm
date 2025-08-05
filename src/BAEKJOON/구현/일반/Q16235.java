import java.util.*;
import java.io.*;

class Tree implements Comparable<Tree> {
    int x;
    int y;
    int age;
    
    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree t) {
        return Integer.compare(this.age, t.age);
    }
}

class Q16235 {

    static int N;
    static int M;
    static int K;
    static int[][] A;
    static int[][] ground;

    static PriorityQueue<Tree> aliveTrees;
    static ArrayDeque<Tree> deadTrees;
    static ArrayDeque<Tree> tempTrees;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        ground = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                ground[i][j] = 5;
            }
        }

        aliveTrees = new PriorityQueue<>();
        deadTrees = new ArrayDeque<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            aliveTrees.offer(new Tree(x - 1, y - 1, z));
        }

        while (K-- > 0) {
            
            // 봄
            tempTrees = new ArrayDeque<>();
            while (!aliveTrees.isEmpty()) {
                Tree t = aliveTrees.poll();
                Tree result = eat(t);
                if (result != null) tempTrees.addLast(result);
            }
            while (!tempTrees.isEmpty()) {
                aliveTrees.offer(tempTrees.pollFirst());
            }
            
            // 여름
            while(!deadTrees.isEmpty()) {
                die(deadTrees.pollFirst());
            }
            
            // 가을
            tempTrees = new ArrayDeque<>();
            for (Tree t : aliveTrees) {
                if (t.age % 5 == 0) plus(t);
            }
            
            while (!tempTrees.isEmpty()) {
                aliveTrees.offer(tempTrees.pollFirst());
            }
            
            // 겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ground[i][j] += A[i][j];
                }
            }
        }

        System.out.print(aliveTrees.size());
    }

    static Tree eat(Tree t) {
        if (ground[t.x][t.y] >= t.age) {
            ground[t.x][t.y] -= t.age;
            t.age += 1;
            return t;
        } else {
            deadTrees.addLast(t);
            return null;
        }
    }

    static void die(Tree t) {
        ground[t.x][t.y] += t.age / 2;
    }

    static void plus(Tree t) {
        for (int d = 0; d < 8; d++) {
            int nx = t.x + dx[d];
            int ny = t.y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            tempTrees.addLast(new Tree(nx, ny, 1));
        }
    }
}
