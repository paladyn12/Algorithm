package BAEKJOON.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 1107
 * 문제 이름: 리모컨
 * 풀이: 현재 채널이 100이므로 N과 100의 차이로 minDiff와 result 초기화
 * 고장난 버튼인지 확인하기 위해 Array에 저장하고 모든 경우의 수에 대해 N과의 차이와 그 때의 길이를 구함
 * 그 결과가 최소가 되는 result를 구해나감
 */
class Q1107_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int wrong = Integer.parseInt(br.readLine());
        boolean[] error = new boolean[10];
        if (wrong != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < wrong; i++) {
                error[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int result = Math.abs(100 - N);

        for (int i = 0; i <= 999999; i++) {

            boolean next = false;
            int length = 0;
            int n = i;

            if (n == 0) {
                if (!error[0]) {
                    length = 1;
                } else {
                    next = true;
                }
            }

            while (n > 0) {
                if (error[n % 10]) {
                    next = true;
                    break;
                }
                length++;
                n /= 10;
            }

            if (!next) {
                // 결과 업데이트
                result = Math.min(result, length + Math.abs(N - i));
            }
        }


        System.out.println(result);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}