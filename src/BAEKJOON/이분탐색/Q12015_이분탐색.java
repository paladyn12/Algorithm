import java.io.*;
import java.util.*;

public class Q12015_이분탐색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[N];
        int lisLength = 1;
        lis[0] = nums[0];
        for (int i = 1; i < N; i++) {
            int key = nums[i];
            if (lis[lisLength - 1] < key) lis[lisLength++] = key;
            else {
                int left = 0;
                int right = lisLength;
                
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                lis[left] = key;
            }
        }

        System.out.print(lisLength);
    }
}
