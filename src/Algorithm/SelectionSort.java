package Algorithm;

import java.io.*;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        selectionSort(array);

        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }

    private static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j <= n-1; j++) {
                if (array[j] < array[minIndex]) minIndex = j;
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
