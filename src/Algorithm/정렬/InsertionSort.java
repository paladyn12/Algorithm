package Algorithm.정렬;

import java.util.Arrays;

public class InsertionSort {
    public static void solution(int[] actual) {

        for (int i = 1; i < actual.length; i++) {
            System.out.println(i + "번 째 " + Arrays.toString(actual));
            int temp = actual[i]; // 중간에 삽입이 될 값
            int j;
            for(j = i - 1; j >= 0; j--) {
                // i 인덱스보다 앞으로 인덱스를 탐색하면서 기준 값 보다 큰 경우 인덱스를 뒤로 하나씩 밈
                if(actual[j] > temp) actual[j + 1] = actual[j];
                else break;
            }
            // 적절한 삽입 위치를 찾음
            // 임시로 담아둔 temp 변수 값을 삽입
            actual[j + 1] = temp;
        }
    }
}
