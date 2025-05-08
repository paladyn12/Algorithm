package GOORM.그래프이론;

import java.io.*;
import java.util.*;

class 가뭄 {
    /**
     * 정비해야하는 수로의 최소 개수를 찾는 문제
     * 모든 지점을 연결하는 최소한의 수로 개수는 (모든 지점의 수 - 1)
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T번 반복
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            // 사실상 쓰는 값은 N 밖에 없음
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
            }
            sb.append(N-1).append("\n");
        }
        System.out.print(sb);
    }
}