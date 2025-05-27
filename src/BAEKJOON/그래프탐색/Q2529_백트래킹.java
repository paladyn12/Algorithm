package BAEKJOON.그래프탐색;

import java.io.*;

/**
 * 문제 번호: 2529
 * 문제 이름: 부등호
 * 풀이: DFS 방식으로 완전 탐색
 * 순서열 for 문으로 돌면서 arr[i] arr[i+1] 비교
 * 모두 통과하면 sb 입력
 */
class Q2529_백트래킹 {

    static int k;
    static char[] comparators;
    static boolean[] visit;
    static int[] array;
    static boolean done;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        k = Integer.parseInt(br.readLine());
        visit = new boolean[10];
        array = new int[k + 1];
        comparators = new char[k];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            comparators[i] = split[i].charAt(0);
        }

        dfs(0, true);
        done = false;
        dfs(0, false);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int depth, boolean desc) {
        if (depth == k + 1) {
            if (logic(comparators, array)) {
                for (int i : array) {
                    sb.append(i);
                }
                sb.append("\n");
                done = true;
            }
            return;
        }
        if (!desc) {
            for (int i = 0; i < 10; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    array[depth] = i;
                    dfs(depth + 1, desc);
                    visit[i] = false;
                }
                if (done) break;
            }
        }
        else {
            for (int i = 9; i >= 0; i--) {
                if (!visit[i]) {
                    visit[i] = true;
                    array[depth] = i;
                    dfs(depth + 1, desc);
                    visit[i] = false;
                }
                if (done) break;
            }
        }
    }

    static boolean logic(char[] comparators, int[] array) {
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            char comparator = comparators[i];
            switch (comparator) {
                case '>':
                    if (array[i] < array[i+1]) flag = false;
                    break;
                case '<':
                    if (array[i] > array[i+1]) flag = false;
                    break;
            }
        }
        return flag;
    }
}

