package GOORM.정렬;

import java.io.*;
import java.util.*;

class 이진수정렬 {
    /**
     * array[2] : { 변환된 2진수의 1의 개수, 기존 10진수 }
     * 다중 조건 정렬 ( 내림 차순 이므로 (o1, o2) -> o2 - o1 )
     * array[K-1][1] 출력
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            array[i][1] = number;
            // 초기화 하면서 2진수의 1의 개수 함께 저장
            array[i][0] = logic(number);
        }

        // 메인 로직
        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o2[0] - o1[0];
        });

        // 정답 출력
        System.out.println(array[K-1][1]);

    }
    static int logic(int number) {
        int count = 0;
        while (number > 0) {
            count += number % 2;
            number /= 2;
        }
        return count;
    }
}