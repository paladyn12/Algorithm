package GOORM.이분탐색;

import java.io.*;
import java.util.*;

public class 방탈출하기 {
    /**
     * 입력 값의 중복 제거, contains() 메서드 사용을 위해 HashSet<Integer> set에 저장
     * M 번 반복하며 입력 값이 set에 포함되어있으면 1, 아니면 0 출력
     */
    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // HashSet<Integer> 선언
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 여러 줄에 걸쳐 출력하므로 성능 향상을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            // 입력 값이 set에 포함되면 1, 없으면 0
            if (set.contains(Integer.parseInt(br.readLine()))) sb.append("1\n");
            else sb.append("0\n");
        }

        // 정답 출력
        System.out.print(sb);

        /**
         * 수열을 A[N]에 저장 후 정렬하면 Arrays.binarySearch(A, 탐색하는 수)를 사용할 수 있음
         */
    }
}
