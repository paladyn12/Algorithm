import java.io.*;
import java.util.*;

public class Q13144_투포인터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int prev = 0;
        long ans = 0;
        int cnt = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                cnt++;
                ans += cnt;
            } else {
                while (arr[prev] != arr[i]) {
                    set.remove(arr[prev]);
                    cnt--;
                    prev++;
                }
                prev++;
                ans += cnt;
            }
        }
        
        System.out.print(ans);
    }
}
