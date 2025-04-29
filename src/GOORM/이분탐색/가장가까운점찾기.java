package GOORM.이분탐색;

import java.io.*;
import java.util.*;

class 가장가까운점찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] points = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            long input = Long.parseLong(br.readLine());
            int index = closestIndex(input, points);
            sb.append(points[index]).append("\n");
        }
        System.out.println(sb);
    }

    private static int closestIndex(long input, long[] points) {
        int left = 0;
        int right = points.length - 1;

        if (input <= points[left]) return left;
        if (input >= points[right]) return right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (points[mid] == input) return mid;

            // 가장 가까운 좌표가 여럿 있는 경우
            // 배열의 연속된 두 원소 사이에 input이 있고 input에서 두 원소 까지의 거리가 같음
            // >> 각 mid 마다 이 전, 이 후 원소 사이에 input 값이 있는지 확인
            if (mid > 0 && points[mid - 1] <= input && input <= points[mid]) {
                return Math.abs(points[mid-1] - input) <= Math.abs(points[mid] - input) ? mid-1 : mid;
            }
            if (mid < points.length - 1 && points[mid] <= input && input <= points[mid+1]) {
                return Math.abs(points[mid] - input) <= Math.abs(points[mid + 1] - input) ? mid : mid + 1;
            }

            if (points[mid] > input) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}