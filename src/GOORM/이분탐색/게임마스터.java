package GOORM.이분탐색;

import java.io.*;
import java.util.*;

class 게임마스터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken()) + 1;

        long left = 1;
        long right = N;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}