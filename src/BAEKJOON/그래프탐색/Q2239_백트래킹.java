import java.util.*;
import java.io.*;

class Q2239_백트래킹 {

	static boolean[] visit;
	static int[][] sudoku;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = input.charAt(j) - '0';
			}
		}

		solve(0, 0);

	}

	static void solve(int row, int col) {
        // 현재 행의 모든 칸을 다 채웠으면 다음 행으로 이동
        if (col == 9) {
            solve(row + 1, 0);
            return;
        }

        // 모든 행을 다 채웠으면 (스도쿠 완성)
        if (row == 9) {
            // 결과 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            // 답을 찾았으므로 시스템 종료 (사전식으로 가장 앞선 답이므로)
            System.exit(0);
        }

        // 현재 칸이 0이 아니라면 (이미 숫자가 채워져 있다면)
        if (sudoku[row][col] != 0) {
            // 다음 칸으로 이동
            solve(row, col + 1);
            return;
        }

        // 현재 칸이 0이라면 (빈칸이라면)
        // 1부터 9까지의 숫자를 시도
        for (int num = 1; num <= 9; num++) {
            // 해당 숫자를 넣을 수 있는지 확인
            if (isValid(row, col, num)) {
                sudoku[row][col] = num; // 숫자를 놓음
                solve(row, col + 1);    // 다음 칸으로 재귀 호출
                sudoku[row][col] = 0;     // 백트래킹 (원래 상태로 되돌림)
            }
        }
    }

    // (row, col) 위치에 num을 넣을 수 있는지 확인하는 함수
    static boolean isValid(int row, int col, int num) {
        // 1. 같은 행에 같은 숫자가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        // 2. 같은 열에 같은 숫자가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }

        // 3. 3x3 박스에 같은 숫자가 있는지 확인
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        // 모든 검사를 통과하면 true 반환
        return true;
    }
}
