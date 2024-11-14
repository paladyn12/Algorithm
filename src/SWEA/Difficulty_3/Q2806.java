package SWEA.Difficulty_3;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Q2806_X
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////

            int N = sc.nextInt();
            List<int[]> result = solveNQueens(N);
            System.out.printf("#%d %d\n", test_case, result.size());

            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
    public static List<int[]> solveNQueens(int n) {
        List<int[]> result = new ArrayList<>();
        int[] board = new int[n];

        backtrack(result, board, 0, n);

        return result;
    }
    public static void backtrack(List<int[]> result, int[] board, int row, int n) {
        if(row == n) {
            result.add(board.clone());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                backtrack(result, board, row+1, n);
                board[row] = -1;
            }
        }


    }
    public static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs((i - row))) {
                return false;
            }
        }
        return true;
    }
}