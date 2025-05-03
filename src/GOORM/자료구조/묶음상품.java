package GOORM.자료구조;

import java.io.*;
import java.util.*;

class 묶음상품 {
    /**
     * 아이템을 묶음으로 만들어 최종적인 묶음 수를 구하는 문제
     * UnionAndFind 알고리즘
     * parent[] : 각 요소의 부모 요소를 가리킴
     * union(a, b) : parent[a]와 parent[b]를 같게 함
     * findRoot(a) : a의 Root 요소를 탐색하며 탐색 과정의 요소들을 Root 요소로 초기화
     * 모든 Union 연산 후 Parent[]의 모든 요소가 root를 가리키도록 모든 요소에 대해 findRoot() 메서드 실행
     * HashSet에 모든 parent[] 값을 add(). 중복 제거를 통해 몇 개의 묶음이 있는지 파악
     */
    static int[] parent;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // M 번의 반복을 돌며 union 연산
        for (int i = 0; i < M; i++) {
            String[] AandB = br.readLine().split(" ");
            int A = Integer.parseInt(AandB[0]);
            int B = Integer.parseInt(AandB[1]);
            union(A, B);
        }

        // 모든 요소의 parent[] 값이 root 요소를 가리키도록 초기화
        for (int i = 1; i <= N; i++) {
            findRoot(i);
        }

        // HashSet으로 묶음 개수를 구해 출력
        HashSet<Integer> result = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            result.add(parent[i]);
        }
        System.out.print(result.size());
    }

    static int findRoot(int N) {
        if (parent[N] != N) {
            parent[N] = findRoot(parent[N]);
        }
        return parent[N];
    }

    static void union(int A, int B) {
        int rootA = findRoot(A);
        int rootB = findRoot(B);
        if (rootA != rootB) {
            parent[rootB] = parent[rootA];
        }
    }
}