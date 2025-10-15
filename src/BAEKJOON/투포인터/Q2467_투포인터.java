import java.io.*;
import java.util.*;

public class Q2467_투포인터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int resultL = 0;
        int resultR = N - 1;
        int ans = 2000000000;
        
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int result = nums[left] + nums[right];
            if (ans > Math.abs(result)) {
                ans = Math.abs(result);
                resultL = left;
                resultR = right;
            }
            if (ans == 0) break;
            else if (result < 0) left++;
            else right--;
        }
        
        System.out.print(nums[resultL] + " " + nums[resultR]);
    }
}
