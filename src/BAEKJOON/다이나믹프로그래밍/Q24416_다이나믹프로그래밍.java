import java.util.*;
import java.io.*;

class Q24416_다이나믹프로그래밍 {
    
    static int fibCnt = 0;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fib(N);

        System.out.print(fibCnt + " " + (N - 2));
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            fibCnt++;
            return 1;
        }
        else return (fib(n-1) + fib(n-2));
    }
}
