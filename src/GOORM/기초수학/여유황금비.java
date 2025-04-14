package GOORM.기초수학;

import java.io.*;
import java.util.*;
class 여유황금비 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st;
        while (test_case-- > 0) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            if (A > B) {
                long temp = A;
                A = B;
                B = temp;
            }
            if (A * 1.6 <= B && B <= A*1.63) count++;

        }

        System.out.print(count);
    }
}