import java.io.*;
import java.util.*;

public class Q30805_그리디 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int idxA = 0;
        int idxB = 0;
        int[] maxA = findMax(A, idxA);
        while (maxA[0] != 0) {
            for (int i = idxB; i < M; i++) {
                if (B[i] == maxA[0]) {
                    ans.add(B[i]);
                    idxB = i + 1;
                    idxA = maxA[1] + 1;
                    break;
                }
            }
            A[maxA[1]] = 0;
            maxA = findMax(A, idxA);
        }

        System.out.println(ans.size());
        if (ans.size() != 0) for (int n : ans) System.out.print(n + " ");
    }

    static int[] findMax(int[] array, int start) {
        int max = 0;
        int maxIdx = 0;
        for (int i = start; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIdx = i;
            }
        }
        return new int[]{max, maxIdx};
    }
}
