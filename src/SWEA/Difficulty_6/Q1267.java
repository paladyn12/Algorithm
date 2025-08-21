package day0821;

import java.io.*;
import java.util.*;


public class Q1267 {
	
	static ArrayList<ArrayList<Integer>> graph;
	static StringBuilder sb = new StringBuilder();
	static int[] degree;
	static boolean[] visit;
	static int V;
	static int[] trace;
	static boolean success;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 2; test_case++) {
			ans = "";
			success = false;
			graph = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			degree = new int[V + 1];
			visit = new boolean[V + 1];
			trace = new int[V + 1];
			
			for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph.get(s).add(e);
				degree[e]++;
			}
			
			dfs(0);
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int depth) {
		if (success) return;
		if (depth == V) {
			for (int i = 0; i < V; i++) ans += (trace[i] + " ");
			success = true;
			return;
		}
		for (int i = 1; i <= V; i++) {
			if (!visit[i] && degree[i] == 0) {
				visit[i] = true;
				trace[depth] = i;
				for (int next : graph.get(i)) {
					degree[next]--;
				}
				
				dfs(depth + 1);
				
				visit[i] = false;
				for (int next : graph.get(i)) {
					degree[next]++;
				}
			}
		}
	}
}
