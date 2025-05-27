package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 15661
 * 문제 이름: 링크와 스타트
 * 풀이: 모든 팀이 되는 경우의 수에 대해 S 값 계산
 * 팀의 인원이 1명부터 N-1명일 때 까지 계산
 * 스타트팀일 때와 링크팀일 때 점수가 다르므로 N-1까지 반복해서 찾아야 함
 */
class Q15661_백트래킹 {

    static int N;
    static int[] nums;
    static int[][] S;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visit = new boolean[N];
        S = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            dfs(0, 0, i);
        }

        System.out.println(result);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int start, int depth, int count) {
        if (depth == count) {
            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] && visit[j]) {
                        startSum += S[i][j] + S[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        linkSum += S[i][j] + S[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(startSum - linkSum));
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1, count);
            visit[i] = false;
        }
    }
}

