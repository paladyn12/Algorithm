package BAEKJOON.자료구조.트리;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1991
 * 문제 이름: 트리 순회
 * 풀이: left[] right[]에서 각 인덱스는 노드를 뜻하며 그 노드의 왼쪽, 오른쪽 자식의 정보를 저장
 * 전위, 중위, 후위 순회 순서에 따라 메서드를 재귀 호출하며 값 출력
 */
class Q1991_트리 {

    // 각 노드(알파벳 A~Z)의 왼쪽, 오른쪽 자식을 저장하는 배열 (-1이면 자식 없음)
    static int[] left;
    static int[] right;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int n = Integer.parseInt(br.readLine());

        left = new int[26];
        right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        // n개의 줄에 걸쳐 각 노드와 자식 노드 정보 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char lchild = st.nextToken().charAt(0);
            char rchild = st.nextToken().charAt(0);
            int idx = parent - 'A';

            if(lchild != '.') {
                left[idx] = lchild - 'A';
            }
            if(rchild != '.') {
                right[idx] = rchild - 'A';
            }
        }

        // 전위 순회
        sb = new StringBuilder();
        preorder(0);
        sb.append("\n");

        // 중위 순회
        inorder(0);
        sb.append("\n");

        // 후위 순회
        postorder(0);
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    // 전위 순회: (루트, 왼쪽, 오른쪽)
    private static void preorder(int node) {
        if (node == -1) return;
        sb.append((char)(node + 'A'));
        preorder(left[node]);
        preorder(right[node]);
    }

    // 중위 순회: (왼쪽, 루트, 오른쪽)
    private static void inorder(int node) {
        if (node == -1) return;
        inorder(left[node]);
        sb.append((char)(node + 'A'));
        inorder(right[node]);
    }

    // 후위 순회: (왼쪽, 오른쪽, 루트)
    private static void postorder(int node) {
        if (node == -1) return;
        postorder(left[node]);
        postorder(right[node]);
        sb.append((char)(node + 'A'));
    }
}