package GOORM.기초구현;

import java.io.*;
import java.util.*;
class 합계산기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st;
        while (test_case-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char operator = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());

            switch (operator) {
                case '+':
                    sum += a+b;
                    break;
                case '-':
                    sum += a-b;
                    break;
                case '*':
                    sum += a*b;
                    break;
                case '/':
                    sum += a/b;
                    break;
            }
        }
        System.out.print(sum);
    }
}