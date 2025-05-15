package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 10973
 * 문제 이름: 이전 순열
 * 풀이: 다음 순열 문제의 반대 버전
 */
public class Q10973_순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 숫자 개수
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 배열 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (previousPermutation(arr)) {
            // 다음 순열이 존재하면 출력
            StringBuilder sb = new StringBuilder();
            for (int num : arr) sb.append(num).append(" ");
            System.out.println(sb);
        } else {
            // 마지막 순열이었다면 -1 출력
            System.out.println(-1);
        }
    }

    static boolean previousPermutation(int[] arr) {
        int i = arr.length - 1;

        // 1. 뒤에서부터 증가하는 첫 위치 찾기 (a[i-1] < a[i])
        while (i > 0 && arr[i - 1] <= arr[i]) i--;

        // 2. 이미 첫 순열인 경우
        if (i <= 0) return false;

        // 3. a[i-1]보다 작은 수 중 가장 오른쪽에 있는 수 찾기 (a[j])
        int j = arr.length - 1;
        while (arr[i - 1] <= arr[j]) j--;

        // 4. 둘을 swap
        swap(arr, i - 1, j);

        // 5. i부터 끝까지 오름차순 정렬 (reverse)
        int start = i, end = arr.length - 1;
        while (start < end) {
            swap(arr, start++, end--);
        }

        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}