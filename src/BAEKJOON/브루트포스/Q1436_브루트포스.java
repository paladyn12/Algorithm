package BAEKJOON.브루트포스;

import java.io.*;
/**
 * 문제 번호: 1436
 * 문제 이름: 영화감독 숌
 * 풀이: n=666부터 수를 증가시키며 666이 들어가면 index 증가
 * index와 입력값이 같아지면 stop
 */
class Q1436_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int n = Integer.parseInt(br.readLine());
        int index = 0;

        for (int i = 666; true; i++) {
            int count = 0;
            int I = i;
            while (I > 0) {
                if (I % 10 == 6) count++;
                else count = 0;
                I /= 10;
                if (count == 3) {
                    index++;
                    break;
                }
            }
            if (index == n) {
                System.out.println(i);
                break;
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}