package GOORM.그래프이론;

import java.io.*;
import java.util.*;

class 연합 {
    /**
     * 연합을 결성한 섬의 개수를 구하는 문제
     * UnionAndFind Algorithm
     * 다리가 놓이면 boolean[][] bridge 에 저장
     * 다리를 놓을 때 반대쪽 다리도 존재하면 union()
     * 각 원소의 root를 HashSet에 넣어 중복을 제거하고 size() 출력
     */

    // 각 섬의 root 저장 배열
    static int[] parent;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 다리 입력 시 이차원 배열에 저장
        boolean[][] bridge = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bridge[s][e] = true;
            // 반대편 다리도 있다면 연합이 구성되었으므로 union()
            if (bridge[e][s]) union(s, e);
        }

        // 각 원소의 root를 중복을 제거하여 개수 출력
        HashSet<Integer> result = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            result.add(find(parent[i]));
        }
        System.out.print(result.size());

    }
    public static void union(int s, int e) {
        int rootS = find(s);
        int rootE = find(e);
        if (rootS != rootE) {
            parent[rootE] = rootS;
        }
    }
    public static int find(int s) {
        if (parent[s] != s) {
            parent[s] = find(parent[s]);
        }
        return parent[s];
    }
}