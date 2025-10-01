import java.util.*;
import java.io.*;

class Q7453_투포인터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        int[] arr1 = new int[N * N];
        int[] arr2 = new int[N * N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr1[i * N + j] = A[i] + B[j];
                arr2[i * N + j] = C[i] + D[j];
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int arr1Idx = 0;
        int arr2Idx = N * N - 1;
        long ans = 0;
        while (arr1Idx < N * N && arr2Idx >= 0) {
            int sum = arr1[arr1Idx] + arr2[arr2Idx];
            if (sum == 0) {
                int n1 = 1;
                int n2 = 1;
                while (arr1Idx + n1 <= N * N - 1 && arr1[arr1Idx] == arr1[arr1Idx + n1]) {
                    n1++;
                }
                while (arr2Idx - n2 >= 0 && arr2[arr2Idx] == arr2[arr2Idx - n2]) {
                    n2++;
                }
                ans += ((long)n1) * n2;
                arr1Idx += n1;
                arr2Idx -= n2;
                
            }
            else if (sum > 0) {
                arr2Idx--;
            } else {
                arr1Idx++;
            }
        }

        System.out.print(ans);
    }
}
