package GOORM.기초알고리즘챌린지;

import java.io.*;
class 시간복잡도 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int two = 0;
        int five = 0;
        for (long i = 2; i <= N; i *= 2) {
            two += N / i;
        }
        for (long i = 5; i <= N; i *= 5) {
            five += N / i;
        }

        System.out.print(Math.min(two, five));
    }
}