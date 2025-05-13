package GOORM.그래프탐색;

import java.io.*;
import java.util.*;

/**
 * 방문할 수 있는 가장 작은 번호의 노드를 탐색하는 문제
 * 각 Node별 탐색 가능한 Node 번호를 저장하기 위한 Node Class 정의
 * 가장 작은 번호의 노드를 탐색하기 위해 TreeSet 이용
 * 다음 노드를 탐색하는 logic() 메서드 구현
 */
class 작은노드 {

    // 노드마다 탐색 가능한 노드를 저장
    static Node[] nodes;
    // 방문한 노드는 true, 방문하지 않은 노드는 false
    static boolean[] visited;
    // 가장 마지막에 방문했던 노드
    static int latest;

    static class Node {
        TreeSet<Integer> linked = new TreeSet<>();
        public void add(int e) {
            linked.add(e);
        }
    }

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }

        // 간선이 양방향이므로 양 쪽의 노드에 서로를 탐색 가능한 노드로 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s].add(e);
            nodes[e].add(s);
        }

        // 시작 노드는 K
        // logic() 메서드를 재귀적으로 호출하여 탐색
        latest = K;
        visited[K] = true;
        logic(K);

        // 결과 출력
        int count = 0;
        for (boolean visit : visited) {
            if (visit) count++;
        }
        System.out.println(count + " " + latest);

    }

    // 입력받은 노드로부터 탐색 가능한 노드를 순회
    // TreeSet으로 구현되어있어 가장 작은 수부터 순회 시작
    static void logic(int K) {
        for (int linkedNode : nodes[K].linked) {
            if (!visited[linkedNode]) {
                visited[linkedNode] = true;
                latest = linkedNode;
                logic(linkedNode);
                break;
            }
        }
    }
}