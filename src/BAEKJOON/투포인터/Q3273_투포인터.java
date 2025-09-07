import java.util.*;
import java.io.*;

class Q3273_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int condition = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int ans = 0;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum < condition) {
                left++;
            } else if (sum > condition) {
                right--;
            } else {
                ans++;
                left++;
                right--;
            }
        }

        System.out.print(ans);
    }
}
