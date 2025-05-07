package GOORM.그래프이론;

import java.io.*;
import java.util.*;

class 폭탄해제 {

    /**
     * 전선과 연결된 각 장치와 연결된 장치의 개수가 2개 이상일 경우 출력하는 문제
     * 각 장치마다 연결된 장치 개수를 bombs 배열에 카운팅
     * 각 전선마다 양 쪽의 장치의 카운트를 확인해 모두 2 이상일 경우 출력
     */

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 장치마다 연결된 장치 수를 저장할 배열
        int[] bombs = new int[N];

        // 전선의 정보를 입력받고 전선과 연결된 양 쪽 장치의 카운트 ++
        int[][] codes = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            codes[i] = new int[]{a, b};
            bombs[a - 1]++;
            bombs[b - 1]++;
        }

        // 각 전선마다 양 쪽의 장치 카운트 모두 2 이상이면 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (bombs[codes[i][0] - 1] > 1 && bombs[codes[i][1] - 1] > 1) sb.append(i + 1).append(" ");
        }

        String result = sb.toString();
        if(result.isEmpty()) System.out.println(-1);
        else System.out.println(result);
    }
}