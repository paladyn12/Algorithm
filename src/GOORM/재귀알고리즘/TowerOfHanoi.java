package GOORM.재귀알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TowerOfHanoi {
    static int K;
    static ArrayDeque<Integer> poll1 = new ArrayDeque<>();
    static ArrayDeque<Integer> poll2 = new ArrayDeque<>();
    static ArrayDeque<Integer> poll3 = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // K 입력
        K = Integer.parseInt(br.readLine());

        // 기둥 초기화
        init();

        // 메인 로직
        hanoi(20, poll1, poll3, poll2);

        // 정답 출력
        System.out.println(sum(poll1) + " " + sum(poll2) + " " + sum(poll3) + " ");
    }

    static void hanoi(int N, ArrayDeque<Integer> start, ArrayDeque<Integer> goal, ArrayDeque<Integer> via) {

        if (count == K) {
            return;
        }

        if (N == 1) {
            move(start, goal);
            count++;
            return;
        }
        hanoi(N-1, start, via, goal);

        if (count == K) {
            return;
        }
        move(start, goal);
        count++;

        hanoi(N-1, via, goal, start);
    }

    static void move(ArrayDeque<Integer> start, ArrayDeque<Integer> goal) {
        goal.addLast(start.pollLast());
    }

    static void init() {
        for (int i = 21; i >= 1; i--) {
            poll1.addLast(i);
        }
        poll2.addLast(21);
        poll3.addLast(21);
    }

    static int sum(ArrayDeque<Integer> poll) {
        int sum = 0;
        for (Integer i : poll) {
            sum += i;
        }
        return sum - 21;
    }
}
