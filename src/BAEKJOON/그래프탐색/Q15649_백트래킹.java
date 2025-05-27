package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 15649
 * 문제 이름: N과 M (1)
 * 풀이: 백트래킹 기법을 이용하여 모든 경우의 수 출력
 */
class Q15649_백트래킹 {

    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(N, M, 0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    public static void dfs(int N, int M, int depth) {

        // 재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열 출력
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            // 만약 해당 노드(값)을 방문하지 않았으면
            if (visit[i] == false) {
                visit[i] = true;      // 해당 노드를 방문 상태로 변경
                arr[depth] = i + 1;   // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N, M, depth + 1);  // 다음 자식 노드 방문을 위해 depth를 1 증가시키며 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
        return;
    }
}