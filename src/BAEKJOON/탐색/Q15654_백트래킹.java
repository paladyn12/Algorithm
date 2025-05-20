package BAEKJOON.탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 15654
 * 문제 이름: N과 M (5)
 * 풀이: 백트래킹 기법을 이용하여 모든 경우의 수 출력
 * 이 전의 문제에서 i+1 로 arr 값을 저장하던 것에서
 * 입력값을 int[] input에 담아 값을 뽑아 저장하도록 변경
 */
class Q15654_백트래킹 {

    static boolean[] visit;
    static int[] arr;
    static int[] input;
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
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    public static void dfs(int depth) {

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
                arr[depth] = input[i];   // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(depth + 1);  // 다음 자식 노드 방문을 위해 depth를 1 증가시키며 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
        return;
    }
}