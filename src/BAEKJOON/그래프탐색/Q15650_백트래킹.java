package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 15650
 * 문제 이름: N과 M (2)
 * 풀이: 백트래킹 기법을 이용하여 모든 경우의 수 출력
 * dfs 호출 시마다 최초 호출 노드 값을 전달하여 그 이상부터 탐색하도록 함
 */
class Q15650_백트래킹 {

    static boolean[] visit;
    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    public static void dfs(int depth, int start) {

        // 재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열 출력
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {

            // 만약 해당 노드(값)을 방문하지 않았으면
            if (visit[i] == false) {
                visit[i] = true;      // 해당 노드를 방문 상태로 변경
                arr[depth] = i + 1;   // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(depth + 1, i);  // 다음 자식 노드 방문을 위해 depth를 1 증가시키며 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
        return;
    }
}