package GOORM.이분탐색;

import java.io.*;
import java.util.*;

class 섭외하기대작전 {
    /**
     * i : 0..N-2, j : i+1..N-1의 이 for 문을 실행
     * 각 반복 마다 S[i] + S[j] 보다 큰 가장 작은 index 발견 ( Arrays.binarySearch(S, S[i] + S[j]) )
     * 찾은 index - j - 1 이 (i, j)에 대해 문제에서 요구하는 조합의 수
     */
    public static void main(String[] args) throws Exception {
        
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] S = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Long.parseLong(st.nextToken());
        }
        
        // Arrays.binarySearch()를 사용하기 위해 미리 Sort
        Arrays.sort(S);

        // 가능한 i, j 조합마다 가능한 조합을 구해 result에 더함
        long result = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = i + 1; j < N-1; j++) {

                int greaterIndex = Arrays.binarySearch(S, S[i] + S[j]);
                if (greaterIndex >= 0) {
                    // 배열에 S[i] + S[j] 값이 있다면 양수, 1을 더해야 S[i] + S[j] 보다 큰 가장 작은 인덱스
                    greaterIndex++;
                } else {
                    // 배열에 S[i] + S[j] 값이 없다면 음수, 양수로 바꿔 1을 빼야 S[i] + S[j] 보다 큰 가장 작은 인덱스
                    greaterIndex = -greaterIndex - 1;
                }
                // 찾은 index가 j + 1 보다 큰 값인 경우에만 result에 적용
                if (greaterIndex > j + 1) {
                    result += greaterIndex - j - 1;
                }
            }
        }

        // 결과 출력
        System.out.print(result);
    }
}