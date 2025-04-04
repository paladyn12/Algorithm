package Algorithm.정렬;

import java.util.Arrays;

public class SelectionSort {
    public static void solution(int[] actual) {

        for (int i = 0; i < actual.length - 1; i++) {
            System.out.println((i+1) + "번 째 " + Arrays.toString(actual));
            int minIndex = i;
            for (int j = i + 1; j < actual.length; j++) {
                if (actual[j] < actual[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = actual[i];
            actual[i] = actual[minIndex];
            actual[minIndex] = temp;
        }
    }
}
