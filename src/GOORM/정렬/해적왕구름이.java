package GOORM.정렬;

import java.io.*;
import java.util.*;

class 해적왕구름이 {
    /**
     * array[3] : { x좌표, y좌표, 입력 받은 순서 }
     * x 좌표와 y 좌표를 이용해 다중 조건 정렬
     * 정렬 후 각 좌표는 사용되지 않으므로 좌표를 저장하던 공간에 약탈 가능한 섬의 개수 저장
     * 입력 받은 순서를 기준으로 정렬
     * 순서대로 약탈 가능한 섬의 개수 출력
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i};
        }

        // 다중 조건 정렬
        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        // x 좌표, y 좌표는 더 이상 쓰지 않으므로 그 자리에 약탈 가능한 섬 개수 저장
        for (int i = 0; i < N; i++) {
            array[i][0] = N - i - 1;
        }

        // 입력 받은 순서를 기준으로 정렬
        Arrays.sort(array, Comparator.comparingInt(o -> o[2]));

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int[] ints : array) {
            sb.append(ints[0]).append("\n");
        }
        System.out.println(sb);
    }
}