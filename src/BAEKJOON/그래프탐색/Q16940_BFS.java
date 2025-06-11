package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 번호: 16940
 * 문제 이름: BFS 스페셜 저지
 * 풀이 : 입력값마다 연결된 자식 수를 구하고 입력 배열에서 해당 자식들을 방문 했는지 확인
 * 방문하지 않았다면 BFS 방식으로 탐색 불가능한 순서로 입력된 것
 * 시작값이 -1인 경우도 실패 처리
 */

class Q16940_BFS {

    static int[] input;
    static boolean[] visit;
    static int N;
    static ArrayList<Integer>[] nodes;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s].add(e);
            nodes[e].add(s);
        }

        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[N + 1];
        boolean flag = checkBFS();
        if (input[0] != 1) flag = false;

        int result = flag ? 1 : 0;
        System.out.println(result);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static boolean checkBFS() {
        int start = 1;
        visit[start] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        int index = 1;

        while (!queue.isEmpty()) {
            start = queue.removeFirst();

            // start 의 child 개수
            int childCount = 0;
            for (int to : nodes[start]) {
                if (!visit[to]) {
                    visit[to] = true;
                    childCount++;
                }
            }

            // start 부터 start 의 child 개수 만큼
            for (int i = index; i < index + childCount; i++) {
                // 자식 노드는 방문 처리 했음
                if (!visit[input[i]]) return false;
                else queue.add(input[i]);
            }
            index += childCount;
        }
        return true;
    }
}