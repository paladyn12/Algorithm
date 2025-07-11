package SWEA.Difficulty_4;


import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Q4193
{
    static int[][] map;
    static boolean[][] visit;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            visit[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            int time = 0;
            boolean failed = false;
            while (!visit[goalX][goalY]) {
                // 완전 탐색 (visit[i][j]일 때) 그 주변이 false이고 map[][]이 1이 아니며 map[][]이 2일 때 time이 % 3 == 2 이면 visit을 true로 초기화

                ArrayList<Position> list = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (visit[i][j]) list.add(new Position(i, j));
                    }
                }

                int sum = 0;
                for (Position p : list) {
                    sum += logic(p.x, p.y, time);
                }

                if (time % 3 == 2 && sum == 0) {
                    failed = true;
                    break;
                }
                time++;
            }
            if (failed) time = -1;
            /////////////////////////////////////////////////////////////////////////////////////////////
            sb.append("#").append(test_case).append(" ").append(time).append("\n");
        }
        System.out.print(sb);
    }

    static int logic(int x, int y, int time) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

            if (map[nextX][nextY] == 0 || (map[nextX][nextY] == 2 && time % 3 == 2)) {
                visit[nextX][nextY] = true;
                sum++;
            }
        }
        return sum;
    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}