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

class Q5215_X
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {

            int N = sc.nextInt();   // 재료의 수
            int L = sc.nextInt();   // 칼로리 제한
            int[][] ingredients = new int[N][2];

            for (int i = 0; i < N; i++) {
                ingredients[i][0] = sc.nextInt();
                ingredients[i][1] = sc.nextInt();
            }

            int result = solveProblem(N, L, ingredients, 0, 0, 0);  // 사용한 재료를 담는 배열

            System.out.printf("#%d %d\n", test_case, result);
        }
    }

    public static int solveProblem(int N, int L, int[][] ingredients, int index, int sumScore, int sumCal) {
        if (sumCal > L) return 0;
        if (index == N) return sumScore;
        int include = solveProblem(N, L, ingredients, index + 1, sumScore + ingredients[index][0], sumCal + ingredients[index][1]);
        int exclude = solveProblem(N, L, ingredients, index + 1, sumScore, sumCal);
        return Math.max(include, exclude);
    }
}