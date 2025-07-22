import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int number;
    int cnt;

    Pair(int number, int cnt) {
        this.number = number;
        this.cnt = cnt;
    }

    public int compareTo(Pair o) {
        if (this.cnt > o.cnt) {
            return 1;
        } else if (this.cnt == o.cnt) {
            return this.number - o.number;
        } else {
            return -1;
        }
    }
}

class Q17140 {

    static int r;
    static int c;
    static int k;
    static int[][] array;

    static int xLength = 3;
    static int yLength = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[101][101];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (cnt <= 100 && array[r][c] != k) {
            logic();
            cnt++;
        }

        if (cnt > 100) System.out.print(-1);
        else System.out.print(cnt);
    }

    static void logic() {
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                R(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                C(i);
            }
        }
    }

    static void R(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= xLength; i++) {
            if (array[key][i] == 0) continue;
            map.compute(array[key][i], (number, cnt) -> cnt == null ? 1 : cnt + 1);
        }
        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            array[key][i++] = p.number;
            array[key][i++] = p.cnt;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            array[key][i++] = 0;
            array[key][i++] = 0;
        }
    }

    static void C(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= yLength; i++) {
            if (array[i][key] == 0) continue;
            map.compute(array[i][key], (number, cnt) -> cnt == null ? 1 : cnt + 1);
        }
        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            array[i++][key] = p.number;
            array[i++][key] = p.cnt;
        }

        xLength = Math.max(xLength, i);

        while (i <= 99) {
            array[i++][key] = 0;
            array[i++][key] = 0;
        }
    }
}
