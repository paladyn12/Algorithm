import java.util.*;

class 커피점제과점 {
	
	static class Node implements Comparable<Node> {
		int idx;
		int cost;
		int type;
		
		public Node(int idx, int cost, int type) {
			this.idx = idx;
			this.cost = cost;
			this.type = type;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}
	}
	
	static int n;
	
	static ArrayList<ArrayList<Node>> graph;
	static PriorityQueue<Node> pq;
	
	static int[] toCoffee;
	static int[] toBakery;
	
	public void init(int N, int K, int sBuilding[], int eBuilding[], int mDistance[]) {
		
		n = N;
		pq = new PriorityQueue<>();
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < K; i++) {
			graph.get(sBuilding[i]).add(new Node(eBuilding[i], mDistance[i], 0));
			graph.get(eBuilding[i]).add(new Node(sBuilding[i], mDistance[i], 0));
		}
		
		return;
	}

	public void add(int sBuilding, int eBuilding, int mDistance) {
		graph.get(sBuilding).add(new Node(eBuilding, mDistance, 0));
		graph.get(eBuilding).add(new Node(sBuilding, mDistance, 0));
		return;
	}

	// 
	public int calculate(int M, int mCoffee[], int P, int mBakery[], int R) {
		toCoffee = new int[n];
		toBakery = new int[n];
		
		Arrays.fill(toCoffee, Integer.MAX_VALUE);
		Arrays.fill(toBakery, Integer.MAX_VALUE);
		
		pq.clear();
		
		for (int i = 0; i < M; i++) toCoffee[mCoffee[i]] = 0;
		for (int i = 0; i < P; i++) toBakery[mBakery[i]] = 0;
		
		for (int i = 0; i < M; i++) {
			for (Node o : graph.get(mCoffee[i])) {
				if (toCoffee[o.idx] == 0) continue;
				if (o.cost > R) continue;
				pq.offer(new Node(o.idx, o.cost, 1));
				toCoffee[o.idx] = Math.min(toCoffee[o.idx], o.cost);
			}
		}
		for (int i = 0; i < P; i++) {
			for (Node o : graph.get(mBakery[i])) {
				if (toBakery[o.idx] == 0) continue;
				if (o.cost > R) continue;
				pq.offer(new Node(o.idx, o.cost, -1));
				mBakery[o.idx] = Math.min(mBakery[o.idx], o.cost);
			}
		}

		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			if ((toCoffee[i] != 0 && toCoffee[i] <= R) && (toBakery[i] != 0 && toBakery[i] <= R)) ans = Math.min(ans, toCoffee[i] + toBakery[i]);
		}
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.cost > R || cur.cost >= ans) break;
			
			if (cur.type == 1) {
				if (toCoffee[cur.idx] < cur.cost) continue;
				for (Node next : graph.get(cur.idx)) {
					if (cur.cost + next.cost > R) continue;
					if (toCoffee[next.idx] > cur.cost + next.cost) {
						toCoffee[next.idx] = cur.cost + next.cost;
						if (toBakery[next.idx] != 0 && toBakery[next.idx] != Integer.MAX_VALUE) {
							ans = Math.min(ans, toCoffee[next.idx] + toBakery[next.idx]);
						}
						pq.offer(new Node(next.idx, toCoffee[next.idx], 1));
					}
				}
			} else if (cur.type == -1) {
				if (toBakery[cur.idx] < cur.cost) continue;
				for (Node next : graph.get(cur.idx)) {
					if (cur.cost + next.cost > R) continue;
					if (toBakery[next.idx] > cur.cost + next.cost) {
						toBakery[next.idx] = cur.cost + next.cost;
						if (toCoffee[next.idx] != 0 && toCoffee[next.idx] != Integer.MAX_VALUE) {
							ans = Math.min(ans, toBakery[next.idx] + toCoffee[next.idx]);
						}
						pq.offer(new Node(next.idx, toBakery[next.idx], -1));
					}
				}
			}
		}


		if (ans == Integer.MAX_VALUE) return -1;
		else return ans;
	}
}
