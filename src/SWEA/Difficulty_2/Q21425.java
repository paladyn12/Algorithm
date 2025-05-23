package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Q21425
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int min = Math.min(A, B);
            int max = Math.max(A, B);
            int temp = 0;

            long sum = min;
            int count = 0;
            while (sum <= N) {
                if (temp % 2 == 0) {
                    min += max;
                } else {
                    max += min;
                }
                sum = Math.max(min, max);
                count++;
                temp++;
            }
            sb.append(count).append("\n");

            /////////////////////////////////////////////////////////////////////////////////////////////

        }

        bw.write(sb.toString());
        bw.flush();
    }
}