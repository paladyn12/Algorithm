package com.algo;

import java.io.*;
import java.util.*;

public class Q1238 {
	
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			graph = new ArrayList<>();
			for (int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<>());
			}
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start_node = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph.get(s).add(e);
			}
			
			int[] visit = new int[101];
			Arrays.fill(visit, -1);
			visit[start_node] = 0;
			int maxLength = 0;
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			dq.addLast(start_node);
			while (!dq.isEmpty()) {
				int cur = dq.pollFirst();
				for (int i = 0; i < graph.get(cur).size(); i++) {
					int next = graph.get(cur).get(i);
					if (visit[next] == -1) {
						visit[next] = visit[cur] + 1;
						maxLength = Math.max(maxLength, visit[cur] + 1);
						dq.addLast(next);
					}
				}
			}
			/*
			for (int i = 0; i <= 100; i++) {
				System.out.print(visit[i] + " ");
			}
			System.out.println();
			*/
			
			for (int i = 1; i <= 100; i++) {
				if (visit[i] == maxLength) ans = i;
			}
			
			sb.append("#").append(test_case).append(" ").append(Math.round(ans)).append("\n");
		}
		System.out.print(sb);
	}
}
