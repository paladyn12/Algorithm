package GOORM.그래프탐색;

import java.io.*;
import java.util.*;

/**
 * 이어진 '#' 픽셀을 구하는 문제
 * '#' 픽셀 기준 상하좌우로 '#' 픽셀이 있다면 queue에 저장
 * -> BFS
 * 이어진 '#' 픽셀의 크기를 ArrayList 에 저장하고 가장 큰 크기와 ArrayList.size() 출력
 */
class 영상처리 {

    // Queue에서 픽셀을 관리하기 위해 정의
    static class Pixel {
        public int x;
        public int y;
        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 각 영역의 크기 저장
    static ArrayList<Integer> objects = new ArrayList<>();
    static char[][] board;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[M][N];
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // '#' 픽셀을 찾아 해당 픽셀과 이어진 '#' 픽셀을 bfs 탐색
        // 탐색된 영역의 크기를 저장
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '#') {
                    objects.add(bfs(i, j));
                }
            }
        }

        // 결과 출력
        int max = Integer.MIN_VALUE;
        for (int size : objects) {
            max = Math.max(max, size);
        }
        System.out.println(objects.size());
        System.out.println(max);
    }

    // '#' 픽셀을 queue에 저장
    // queue가 빌 때까지 반복하여 탐색한 영역의 count를 반환
    static int bfs(int x, int y) {

        ArrayDeque<Pixel> queue = new ArrayDeque<>();
        int count = 0;
        queue.addLast(new Pixel(x, y));
        while (!queue.isEmpty()) {

            Pixel curr = queue.removeFirst();
            board[curr.x][curr.y] = '.';
            count++;

            if (curr.x - 1 >= 0 && board[curr.x - 1][curr.y] == '#') {
                board[curr.x - 1][curr.y] = '.';
                queue.addLast(new Pixel(curr.x - 1, curr.y));
            }
            if (curr.y + 1 < N && board[curr.x][curr.y + 1] == '#') {
                board[curr.x][curr.y + 1] = '.';
                queue.addLast(new Pixel(curr.x, curr.y + 1));
            }
            if (curr.x + 1 < M && board[curr.x + 1][curr.y] == '#') {
                board[curr.x + 1][curr.y] = '.';
                queue.addLast(new Pixel(curr.x + 1, curr.y));
            }
            if (curr.y - 1 >= 0 && board[curr.x][curr.y - 1] == '#') {
                board[curr.x][curr.y - 1] = '.';
                queue.addLast(new Pixel(curr.x, curr.y - 1));
            }
        }
        return count;
    }
}