package BAEKJOON.그리디;

import java.io.*;

/**
 * 문제 번호: 2839
 * 문제 이름: 설탕 배달
 * 풀이: 5로 나뉘어지면 전부 5로 나누고 break
 * 그렇지 않으면 -3
 * N이 음수로 떨어지면 나뉘어지지 않는 것이므로 -1
 */
class Q2839_그리디 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            if (N % 5 == 0) {
                count += N / 5;
                break;
            }
            N -= 3;
            count ++;
            if (N < 0) {
                count = -1;
                break;
            }
        }

        System.out.println(count);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}