package GOORM.재귀알고리즘;

import java.io.*;
import java.util.*;

class BiggerThanYou {
    static int N;
    static int[] A;
    static long K;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        K = Long.parseLong(br.readLine());

        // 메인 로직
        logic(0);

        // 정답 출력
        System.out.println(min);
    }

    static void logic(long num) {
        if (num > K) {
            min = Math.min(num, min);   // 이번에 들어온 num이 K 보다 크다면 최소 값 갱신 시도
            return;
        }
        for (int i = 0; i < N; i++) {
            long nextNum = num * 10 + A[i];      // 사용 가능한 수들을 사용해 수를 모든 조합으로 붙여봄
            if (nextNum == 0) continue;
            logic(nextNum);
        }
    }
}