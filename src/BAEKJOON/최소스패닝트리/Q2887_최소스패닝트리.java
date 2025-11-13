import java.io.*;
import java.util.*;

public class Q2887_최소스패닝트리 {

    // 1. 행성 정보를 저장할 Planet 클래스
    static class Planet {
        int id; // 행성의 고유 번호 (0 ~ N-1)
        int x, y, z;

        Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    // 2. 간선 정보를 저장할 Edge 클래스 (비용 기준 정렬)
    static class Edge implements Comparable<Edge> {
        int u, v; // 연결된 두 행성의 id
        int cost; // 터널 건설 비용

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        // 비용(cost)을 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    // 3. Union-Find를 위한 부모 테이블
    static int[] parent;

    // find 연산 (경로 압축 적용)
    static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    // union 연산
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 행성 정보 저장 (x, y, z 좌표 및 고유 id)
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        // 4. 간선 리스트 생성 (핵심 로직)
        ArrayList<Edge> edges = new ArrayList<>();

        // X좌표 기준으로 정렬 후 간선 추가
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.x, p2.x));
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets[i];
            Planet p2 = planets[i + 1];
            int cost = Math.abs(p1.x - p2.x);
            // 문제의 비용 함수는 min(|xA-xB|, |yA-yB|, |zA-zB|) 입니다.
            // 하지만 |xA-xB|만으로 간선을 만들어도 됩니다.
            // 어차피 y, z 정렬 시 |yA-yB|와 |zA-zB|가 최소인 간선이 따로 추가됩니다.
            // 이 중 가장 작은 값이 MST에 사용됩니다.
            edges.add(new Edge(p1.id, p2.id, cost));
        }

        // Y좌표 기준으로 정렬 후 간선 추가
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.y, p2.y));
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets[i];
            Planet p2 = planets[i + 1];
            int cost = Math.abs(p1.y - p2.y);
            edges.add(new Edge(p1.id, p2.id, cost));
        }

        // Z좌표 기준으로 정렬 후 간선 추가
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.z, p2.z));
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets[i];
            Planet p2 = planets[i + 1];
            int cost = Math.abs(p1.z - p2.z);
            edges.add(new Edge(p1.id, p2.id, cost));
        }

        // 5. Kruskal 알고리즘 수행
        
        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        // Union-Find 부모 테이블 초기화
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        long totalCost = 0; // 총 비용 (int 범위를 넘을 수 있으니 long 사용)
        int edgeCount = 0; // 연결된 간선의 수

        for (Edge edge : edges) {
            // 두 행성이 아직 연결되지 않았다면 (사이클이 생기지 않는다면)
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v); // 두 행성을 연결
                totalCost += edge.cost;
                edgeCount++;
            }

            // N-1개의 간선이 모두 연결되면 MST 완성
            if (edgeCount == N - 1) {
                break;
            }
        }

        System.out.println(totalCost);
    }
}
