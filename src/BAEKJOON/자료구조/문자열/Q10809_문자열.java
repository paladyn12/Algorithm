package BAEKJOON.자료구조.문자열;

import java.io.*;

/**
 * 문제 번호: 10809
 * 문제 이름: 알파벳 찾기
 * 풀이: 각 문자열이 나왔는지를 count[]로 확인
 * count[]의 값이 -1이면 처음 나온 것 이므로 해당 값에 index 저장
 */
class Q10809_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String s = br.readLine();
        int[] count = new int[26];
        for (int i = 0; i < count.length; i++) {
            count[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)-'a'] == -1) count[s.charAt(i)-'a'] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : count) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
