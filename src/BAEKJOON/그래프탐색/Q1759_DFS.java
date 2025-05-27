package BAEKJOON.그래프탐색;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1759
 * 문제 이름: 암호 만들기
 * 풀이: dfs 방식으로 모든 경우의 수 출력
 * 비밀번호의 조건을 만족하도록 자음, 모음 개수를 trace하며 dfs 수행
 */
class Q1759_DFS {

    static HashSet<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb = new StringBuilder();
    static int L;
    static int C;
    static char[] chars;
    static char[] cur;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        cur = new char[L];
        visit = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        dfs(0, 0, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();

    }

    static void dfs(int start, int depth, int vowelCount, int consonantCount) {
        if (depth == L) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                for (char c : cur) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cur[depth] = chars[i];
                if (vowel.contains(chars[i]))
                    dfs(i + 1, depth + 1, vowelCount + 1, consonantCount);
                else
                    dfs(i + 1, depth + 1, vowelCount, consonantCount + 1);
                visit[i] = false;
            }
        }
    }
}