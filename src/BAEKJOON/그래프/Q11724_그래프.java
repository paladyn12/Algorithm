package BAEKJOON.그래프;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제 번호: Q11724
 * 문제 이름: 연결 요소의 개수
 * 풀이 : Union - Find
 */
class Q11724 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            union(s, e);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }
        System.out.println(set.size());

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static int find(int e) {
        if (e != parent[e]) {
            parent[e] = find(parent[e]);
        }
        return parent[e];
    }

    static void union(int s, int e) {
        int rootS = find(s);
        int rootE = find(e);
        if (rootS != rootE) {
            parent[rootE] = rootS;
        }
    }
}