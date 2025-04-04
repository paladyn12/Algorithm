package Algorithm.정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 다중조건정렬 {
    public static void main(String[] args) {
        int[][] dots = new int[5][2];
        Arrays.sort(dots, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });
    }
}
