package GOORM.이분탐색;

import java.io.*;
import java.util.*;

class 게임마스터 {

    static long MAX = (long) Math.pow(10, 12);

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long goalRate = (M * 100) / N + 1;

        if (goalRate >= 100) {
            System.out.println("X");
            return;
        }

        long left = 0;
        long right = MAX - 1;
        long result = -1;
        while (left <= right) {
            long mid = (right + left) / 2;
            long currentRate = ((M + mid) * 100) / (N + mid);
            if ( currentRate >= goalRate ) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}