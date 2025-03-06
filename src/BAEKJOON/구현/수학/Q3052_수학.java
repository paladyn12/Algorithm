package BAEKJOON.구현.수학;

import java.io.*;
import java.util.HashSet;

/**
 * 문제 번호: 3052
 * 문제 이름: 나머지
 * 풀이: HashSet으로 중복 제거
 */
class Q3052_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(Integer.parseInt(br.readLine())%42);
        }

        System.out.println(set.size());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}