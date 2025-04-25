package GOORM.완전탐색;

import java.io.*;
import java.util.*;

class 구름RPG2 {
    /**
     * 미리 2 ~ 100,000 까지의 소수 판별
     * N개의 입력 마다 입력된 값이 소수인지 판별
     * 소수가 아니면 소수일 때 까지 1씩 값을 감소시키며 감소시킨 횟수를 출력
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        int N = Integer.parseInt(br.readLine());

        // 2 ~ 100,000 까지의 소수 판별
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 100000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 100000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // N번의 반복
        // 매번 System.out.println을 출력하면 성능이 저하되므로 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {

            // 소수가 아니면 소수일 때 까지 1씩 감소
            // 소수이면 바로 빠져나옴
            int count = 0;
            int i = Integer.parseInt(br.readLine());
            while (!isPrime[i]) {
                count++;
                i--;
            }
            sb.append(count).append("\n");
        }

        // 정답 출력
        System.out.print(sb);
    }
}