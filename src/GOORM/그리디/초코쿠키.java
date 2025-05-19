package GOORM.그리디;

import java.io.*;
import java.util.*;

/**
 * 매 초 1씩 감소하는 값들의 최대 곱을 구하는 문제
 * 이차원배열 A[][] 에 각 쿠키의 맛있는 정도와 순서를 저장 ( A [ [A1, 1], [A2, 2], ..., [AN, N] ]
 * ※ 0이 선택되면 안되므로 가장 작은 값부터, 값이 같다면 앞서는 순서부터 선택하면 최대 곱이 나옴 ※
 * 가장 작은 값부터 1~N 까지의 반복값을 돌려 이보다 작으면 무조건 최대 곱이 0이 되는 경우임
 * ex) 1 2 3 3 의 경우 4번째 반복 값으로 3이 선택. 이는 4보다 작으므로 어떻게 해도 모든 값을 0이 되기 전에 구하는 방법이 없음
 * 이 때는 그냥 사전 순으로 정렬
 */
class 초코쿠키 {
    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 맛있는 정도와 입력받은 순서 저장
            A[i] = new int[]{Integer.parseInt(st.nextToken()), i + 1};
        }

        // 맛있는 정도를 기준으로, 같다면 앞서는 순서대로 정렬
        Arrays.sort(A, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        // 맛있는 정도를 작은 값부터 순회하며 모두 0이 되기 전에 선택 가능한지 파악
        boolean valid = true;
        for (int i = 0; i < N; i++) {
            if (A[i][0] < i + 1) valid = false;
        }

        // 만약 모두 0이 되기 전에 고를 수 없다면 그냥 입력받은 순으로 정렬
        if (!valid) Arrays.sort(A, Comparator.comparingInt(o -> o[1]));

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int[] a : A) {
            sb.append(a[1]).append(" ");
        }
        System.out.print(sb);
    }
}