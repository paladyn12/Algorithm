package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Q12712
{

    static int N;
    static int M;
    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);
            int[][] flys = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    flys[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = Math.max(result, logic(flys, i, j));
                }
            }

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
            /////////////////////////////////////////////////////////////////////////////////////////////
        }

        System.out.println(sb);
    }

    static int logic(int[][] flys, int x, int y) {
        int countA = flys[x][y];
        int countB = flys[x][y];

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 8; j++) {
                int nextX = x + dx[j] * i;
                int nextY = y + dy[j] * i;
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (j % 2 == 0) {
                    countA += flys[nextX][nextY];
                } else {
                    countB += flys[nextX][nextY];
                }
            }
        }

        return Math.max(countA, countB);
    }
}