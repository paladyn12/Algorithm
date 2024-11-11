package SWEA.Difficulty_3;

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


class Q1208
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int[] boxes = new int[100];
            int dump = sc.nextInt();

            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }

            for (int i = 0; i < dump; i++) {

                int max = Integer.MIN_VALUE;
                int maxIdx = 0;
                int min = Integer.MAX_VALUE;
                int minIdx = 99;

                for (int j = 0; j < 100; j++) {
                    if (boxes[j] > max) {
                        max = boxes[j];
                        maxIdx = j;
                    } else if (boxes[j] < min) {
                        min = boxes[j];
                        minIdx = j;
                    }
                }

                boxes[maxIdx]--;
                boxes[minIdx]++;
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < 100; j++) {
                if (boxes[j] > max) {
                    max = boxes[j];
                }
                if (boxes[j] < min) {
                    min = boxes[j];
                }
            }

            System.out.printf("#%d %d\n", test_case, max-min);
        }
    }
}