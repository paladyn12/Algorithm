package BAEKJOON.탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 번호: 13023
 * 문제 이름: ABCDE
 * 풀이: DFS 방식으로 탐색 깊이가 5가 되면 성공
 */
class Q13023_DFS {

    static class Person {
        int number;
        ArrayList<Integer> friend = new ArrayList<>();

        public Person(int number) {
            this.number = number;
        }

        public void add(int e) {
            friend.add(e);
        }
    }
    static Person[] people;
    static boolean[] visit;
    static boolean flag;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        people = new Person[N];
        for (int i = 0; i < N; i++) {
            people[i] = new Person(i);
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            people[s].add(e);
            people[e].add(s);
        }

        for (int i = 0; i < N; i++) {

            visit[i] = true;
            dfs(i, 1);
            visit[i] = false;

            if (flag) break;
        }

        int result = flag ? 1 : 0;
        System.out.println(result);

        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int start, int depth) {
        if (depth == 5) {
            flag = true;
            return;
        }

        Person cur = people[start];
        for (Integer i : cur.friend) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}