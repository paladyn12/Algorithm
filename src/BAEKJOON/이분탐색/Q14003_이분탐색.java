import java.io.*;
import java.util.*;

public class Q14003_이분탐색 {
    public static void main(String[] args) throws IOException {
        
        // 1. 빠른 입출력을 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 2. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. LIS 길이 계산 및 dp 배열 생성
        
        // lis: O(N log N) LIS 길이를 계산하기 위한 임시 리스트
        ArrayList<Integer> lis = new ArrayList<>();
        
        // dp[i] = A[i]를 마지막으로 하는 LIS의 길이
        int[] dp = new int[N]; 
        
        for (int i = 0; i < N; i++) {
            int num = A[i];
            
            // Collections.binarySearch는 lower_bound와 유사하게 동작
            // 1. 값을 찾으면: 해당 인덱스 (>= 0)
            // 2. 값을 못찾으면: -(insertion point) - 1
            int idx = Collections.binarySearch(lis, num);
            
            // 값을 못찾았을 경우, insertion point 계산
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == lis.size()) {
                // Case 1: num이 lis의 모든 원소보다 크면, 맨 뒤에 추가
                lis.add(num);
                dp[i] = lis.size(); // 현재 LIS의 길이가 dp[i] 값이 됨
            } else {
                // Case 2: num이 lis[idx]보다 작거나 같으면, 덮어쓰기
                lis.set(idx, num);
                dp[i] = idx + 1;    // 덮어쓴 위치 + 1 (인덱스는 0부터 시작)
            }
        }
        
        // 4. LIS 길이 출력
        int maxLen = lis.size();
        bw.write(maxLen + "\n");
        
        // 5. LIS 수열 역추적 (Stack 사용)
        Stack<Integer> stack = new Stack<>();
        
        // 수열 A를 뒤에서부터 탐색
        for (int i = N - 1; i >= 0; i--) {
            // dp[i] 값이 현재 찾아야 하는 길이(maxLen)와 같다면
            if (dp[i] == maxLen) {
                stack.push(A[i]); // 스택에 추가
                maxLen--;         // 다음에는 LIS 길이가 1 작은 값을 찾음
            }
            
            // maxLen이 0이 되면 모든 LIS 원소를 찾은 것
            if (maxLen == 0) {
                break;
            }
        }
        
        // 6. 스택에서 pop 하면서 LIS 수열 출력
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        
        bw.write(sb.toString().trim() + "\n");
        
        // 7. 자원 해제
        bw.flush();
        bw.close();
        br.close();
    }
}
