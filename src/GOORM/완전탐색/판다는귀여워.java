package GOORM.완전탐색;

import java.io.*;
import java.util.*;

class 판다는귀여워 {
    /**
     * 판다 위치를 pandas[2] 에 저장
     * 모든 좌표마다 불만족도 계산하며 결과값을 줄여나감
     * 해당 좌표에 판다가 있으면 최대값으로 초기화
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] pandas = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            pandas[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        // 메인 로직
        // 모든 좌표에 대해 모든 판다로부터의 거리를 더함
        // 판다가 있는 위치인 경우 결과를 최대값으로 초기화하여 result에 영향을 주지 않고 다음으로 넘어감
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                int sum = 0;
                for (int k = 0; k < K; k++) {
                    if (i == pandas[k][0] && j == pandas[k][1]) {
                        sum = Integer.MAX_VALUE;
                        break;
                    }
                    else {
                        sum += (int) Math.pow(i - pandas[k][0], 2) + (int) Math.pow(j - pandas[k][1], 2);
                    }
                }
                min = Math.min(min, sum);
            }
        }

        System.out.print(min);
    }
}