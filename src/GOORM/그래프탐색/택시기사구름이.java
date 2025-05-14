package GOORM.그래프탐색;

import java.io.*;
import java.util.*;

/**
 * 택시로부터의 거리를 BFS 방식으로 구해 수익과 통행료를 구하는 문제
 * 손님을 태우러 가는 거리는 통행료만 구함 (tax)
 * 손님의 하차지점 까지 가는 거리는 통행료와 수익 모두 구함 (tax, income)
 * 각 이동마다 현재 택시 위치로부터 목표 지점까지 거리는 BFS 방식으로 구하고 그 거리를 기반으로 통행료와 수익 계산
 * drive(int x, int y, boolean getIncome) : 현재 택시 위치로부터 목표 지점인 x, y 좌표까지 거리를 BFS 방식으로 계산
 *                                          getIncome 여부에 따라 통행료만 계산 or 통행료와 수익 모두 계산
 * 최종적인 income - tax를 출력
 */

class 택시기사구름이 {

    // 좌표를 다루기 위한 class
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 통행료
    static int tax = 0;
    // 수입
    static int income = 0;
    // 택시의 현재 위치
    static Point taxi;
    // 택시로부터의 거리
    static int[][] distance;

    // 입력받는 변수들
    static int N;
    static int M;
    static int[][] map;
    static int X;
    static int Y;
    static int Z;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 좌표는 0-base index로 저장하기 위해 -1
        int[][] points = new int[M][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                points[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        // 좌표가 (열, 행) 순서로 입력되므로 메서드에 순서를 바꿔서 전달
        for (int i = 0; i < M; i++) {

            // 첫 손님 위치는 택시 위치이므로 이동하지 않음
            if (i == 0) {
                taxi = new Point(points[i][1], points[i][0]);
            }
            // 그 외엔 손님을 태우러 갈 때 수익을 계산하지 않고 통행료만 계산하는 drive() 메서드 수행
            else {
                drive(points[i][1], points[i][0], false);
            }
            // 손님을 태우고 하차 지점까지 갈 땐 통행료, 수익 모두 계산하는 drive() 메서드 수행
            drive(points[i][3], points[i][2], true);
        }

        // 결과 출력
        System.out.println(income - tax);
    }

    // BFS 방식으로 현재 택시 위치로부터 x, y 좌표까지의 거리를 계산하고 통행료와 수익 계산
    static void drive(int x, int y, boolean getIncome) {

        // 택시로부터의 거리를 -1로 초기화
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }
        // BFS 탐색을 위한 queue 선언
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(taxi);
        distance[taxi.x][taxi.y] = 0;

        // 탐색 위치가 0 이면서 택시로부터의 거리가 -1인 경우만 탐색
        while (!queue.isEmpty()) {
            Point curr = queue.removeFirst();
            int currDistance = distance[curr.x][curr.y];
            if (curr.x - 1 >= 0 && distance[curr.x - 1][curr.y] == -1 && map[curr.x - 1][curr.y] == 0) {
                queue.addLast(new Point(curr.x - 1, curr.y));
                distance[curr.x - 1][curr.y] = currDistance + 1;
            }
            if (curr.x + 1 < N && distance[curr.x + 1][curr.y] == -1 && map[curr.x + 1][curr.y] == 0) {
                queue.addLast(new Point(curr.x + 1, curr.y));
                distance[curr.x + 1][curr.y] = currDistance + 1;
            }
            if (curr.y - 1 >= 0 && distance[curr.x][curr.y - 1] == -1 && map[curr.x][curr.y - 1] == 0) {
                queue.addLast(new Point(curr.x, curr.y - 1));
                distance[curr.x][curr.y - 1] = currDistance + 1;
            }
            if (curr.y + 1 < N && distance[curr.x][curr.y + 1] == -1 && map[curr.x][curr.y + 1] == 0) {
                queue.addLast(new Point(curr.x, curr.y + 1));
                distance[curr.x][curr.y + 1] = currDistance + 1;
            }
        }

        // 탐색 후 택시는 목표 지점으로 이동
        taxi.x = x;
        taxi.y = y;

        // getIncome이 false이면 통행료만, true이면 통행료와 수익 모두 계산
        tax += distance[x][y] * Z;
        if (getIncome) {
            if (distance[x][y] <= 5) income += X;
            else {
                income += X + (distance[x][y] - 5) * Y;
            }
        }
    }
}