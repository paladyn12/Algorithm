import java.io.*;
import java.util.*;

public class Q2143_투포인터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        int[] originA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) originA[i] = Integer.parseInt(st.nextToken());
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += originA[j];
                A.add(sum);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] originB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) originB[i] = Integer.parseInt(st.nextToken());
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += originB[j];
                B.add(sum);
            }
        }

        Collections.sort(A);
        Collections.sort(B);

        int leftA = 0;
        int rightB = B.size() - 1;

        long ans = 0;
        while (leftA < A.size() && rightB >= 0) {
            int sum = A.get(leftA) + B.get(rightB);
            if (sum < T) {
                leftA++;
            } else if (sum > T) {
                rightB--;
            } else {
                
                int leftIdx = 1;
                int rightIdx = 1;
                
                while (leftA + leftIdx < A.size() && A.get(leftA).equals(A.get(leftA + leftIdx))) {
                    leftIdx++;
                }
                while (rightB - rightIdx >= 0 && B.get(rightB).equals(B.get(rightB - rightIdx))) {
                    rightIdx++;
                }
                
                ans += ((long)leftIdx) * rightIdx;
                leftA += leftIdx;
                rightB -= rightIdx;
            }
        }
        System.out.print(ans);
    }
}
