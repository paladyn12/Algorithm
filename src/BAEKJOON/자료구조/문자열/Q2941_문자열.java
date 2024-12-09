package BAEKJOON.자료구조.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 문제 번호: 10988
 * 문제 이름: 크로아티아 알파벳
 * 문제 링크: https://www.acmicpc.net/problem/10988
 * 풀이: 알파벳을 하나씩 검사하며 c, d, l, n, s, z 가 나왔을 때 다음 글자와 합쳐 크로아티아 알파벳이 되면 index를 하나 건너뜀
 */
class Q2941_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String str = br.readLine();

        for (String croatianAlphabet : croatianAlphabets) {
            while (str.contains(croatianAlphabet)) {
                str = str.replace(croatianAlphabet, " ");
            }
        }

        System.out.println(str.length());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}