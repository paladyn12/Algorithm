import java.util.*;
import java.io.*;

class Q1799_백트래킹 {

    static int N;
    static int[][] board;
    static int[] ans = new int[2]; // ans[0]: 흰 칸 최대, ans[1]: 검은 칸 최대
    
    // 대각선 방문 여부 체크용 배열
    // 1. (r - c) 값이 같은 대각선 (오른쪽 아래/왼쪽 위)
    static boolean[] diag_diff; // r-c 값 범위: -(N-1) ~ (N-1). 인덱스: r-c + (N-1)
    // 2. (r + c) 값이 같은 대각선 (왼쪽 아래/오른쪽 위)
    static boolean[] diag_sum;  // r+c 값 범위: 0 ~ 2*(N-1). 인덱스: r+c

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        // 대각선 배열 초기화 (크기는 넉넉하게 2*N-1)
        diag_diff = new boolean[2 * N - 1];
        diag_sum = new boolean[2 * N - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 흰 칸(color=0)에 대해 DFS 수행
        dfs(0, 0, 0, 0); 
        // 2. 검은 칸(color=1)에 대해 DFS 수행
        dfs(0, 0, 0, 1);

        System.out.print(ans[0] + ans[1]);
    }

    /**
     * @param r 현재 행
     * @param c 현재 열
     * @param cnt 현재까지 놓은 비숍 개수
     * @param color 탐색할 칸의 색 (0: 흰 칸, 1: 검은 칸)
     */
    static void dfs(int r, int c, int cnt, int color) {

        // (r, c) 부터 시작해서 보드 끝까지 탐색
        for (int i = r; i < N; i++) {
            // 현재 행(i)이 시작 행(r)과 같으면 현재 열(c)부터,
            // 다음 행부터는 0번 열부터 시작
            int start_j = (i == r) ? c : 0; 
            
            for (int j = start_j; j < N; j++) {
                
                // 1. 현재 칸의 색이 탐색하려는 색과 다르면 스킵
                if ((i + j) % 2 != color) {
                    continue;
                }
                
                // 2. 비숍을 놓을 수 없는 칸(0)이면 스킵
                if (board[i][j] == 0) {
                    continue;
                }

                // 3. 대각선이 겹치는지 O(1) 확인
                int diff_idx = i - j + (N - 1);
                int sum_idx = i + j;

                if (!diag_diff[diff_idx] && !diag_sum[sum_idx]) {
                    // 비숍을 놓는다 (대각선 방문 처리)
                    diag_diff[diff_idx] = true;
                    diag_sum[sum_idx] = true;

                    // 다음 위치 계산 (현재 위치 (i, j)의 다음 칸)
                    int next_r = i;
                    int next_c = j + 1;
                    if (next_c == N) { // 열이 끝에 도달하면 다음 행 0번 열로
                        next_r = i + 1;
                        next_c = 0;
                    }

                    // (i, j) 다음 칸부터 다시 탐색 시작
                    dfs(next_r, next_c, cnt + 1, color);

                    // 백트래킹 (놓았던 비숍을 치운다)
                    diag_diff[diff_idx] = false;
                    diag_sum[sum_idx] = false;
                }
            }
        }

        // (r, c)부터 보드 끝까지 모든 칸을 확인한 후,
        // (더 이상 놓을 곳이 없거나 모든 경우를 탐색한 경우)
        // 현재까지 놓은 비숍 개수(cnt)로 최대값 갱신
        ans[color] = Math.max(ans[color], cnt);
    }
}
