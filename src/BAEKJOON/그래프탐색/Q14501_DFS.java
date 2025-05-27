package BAEKJOON.그래프탐색;

import java.io.*;

/**
 * 문제 번호: 14501
 * 문제 이름: 퇴사
 * 풀이: 상담의 걸리는 시간과 받는 비용을 Class에 정의
 * DFS 탐색을 돌며 N일차 내에 처리할 수 있는 상담인 경우 비용을 더해가며 result 계산
 */
class Q14501_DFS {

    static class Counsel {
        int T;
        int P;

        public Counsel(int t, int p) {
            T = t;
            P = p;
        }
    }

    static int N;
    static Counsel[] counsels;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        counsels = new Counsel[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            counsels[i] = new Counsel(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        dfs(1, 0);

        System.out.println(result);
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    static void dfs(int start, int income) {

        result = Math.max(result, income);

        for (int i = start; i <= N; i++) {
            Counsel counsel = counsels[i];
            if (i + counsel.T <= N + 1) {
                dfs(i + counsel.T, income + counsel.P);
            }
        }
    }
}