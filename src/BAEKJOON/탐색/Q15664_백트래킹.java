package BAEKJOON.탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 15664
 * 문제 이름: N과 M (10)
 * 풀이: before 변수에 같은 인덱스의 이전 값을 저장하여 중복 방지
 * start 변수로 시작 이전에 dfs를 방문한 값보다 큰 값을 찾도록 함
 */
class Q15664_백트래킹 {

    static int N;
    static int M;
    static int[] array;
    static int[] nums;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        nums = new int[N];
        array = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                if (before != nums[i]) {
                    array[depth] = nums[i];
                    before = nums[i];
                    visit[i] = true;
                    dfs(depth + 1, i + 1);
                    visit[i] = false;
                }
            }
        }
    }
}