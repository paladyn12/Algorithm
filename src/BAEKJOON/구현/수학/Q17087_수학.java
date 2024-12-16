package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 17087
 * 문제 이름: 숨바꼭질 6
 * 문제 링크: https://www.acmicpc.net/problem/17087
 * 풀이: 배열에 현 지점으로부터 떨어진 거리를 저장하여 전체 원소의 최대공약수 계산
 */
class Q17087_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] players = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) players[i] = Math.abs(S-Integer.parseInt(st.nextToken()));

        int gcd = players[0];
        boolean flag = true;
        for (int i = 1; i < N; i++) {
            gcd = GCD(gcd, players[i]);
            if (gcd == 1) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println(gcd);
        else System.out.println(1);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
    private static int GCD(int a, int b) {
        if (b==0) return a;
        else return GCD(b, a%b);
    }
}