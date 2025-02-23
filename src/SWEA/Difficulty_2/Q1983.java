package SWEA.Difficulty_2;

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Q1983
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();



        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////

            int N = sc.nextInt();
            int n = N/10;
            int K = sc.nextInt()-1;

            double[] scoreNum = new double[N];
            String[] score = new String[N];
            for (int i = 0; i < N; i++) {
                scoreNum[i] = sc.nextInt()*0.35 + sc.nextInt()*0.45 + sc.nextInt()*0.2;
            }

            // N 번 반복해 최고점을 찾아 score에 학점을 넣고 -1로 초기화
            for (int i = 0; i < N; i++) {

                double max = 0.0;
                int idx = 0;

                for (int j = 0; j < N; j++) {
                    if (scoreNum[j] >= max) {
                        idx = j;
                        max = scoreNum[j];
                    }
                }

                scoreNum[idx] = -1;
                if (i < n) {
                    score[idx] = "A+";
                } else if (i < 2*n) {
                    score[idx] = "A0";
                } else if (i < 3*n) {
                    score[idx] = "A-";
                } else if (i < 4*n) {
                    score[idx] = "B+";
                } else if (i < 5*n) {
                    score[idx] = "B0";
                } else if (i < 6*n) {
                    score[idx] = "B-";
                } else if (i < 7*n) {
                    score[idx] = "C+";
                } else if (i < 8*n) {
                    score[idx] = "C0";
                } else if (i < 9*n) {
                    score[idx] = "C-";
                } else if (i < 10*n) {
                    score[idx] = "D0";
                }
            }

            System.out.printf("#%d %s\n", test_case, score[K]);

            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
