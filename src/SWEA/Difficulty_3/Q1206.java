package SWEA.Difficulty_3;

import java.util.Scanner;

class Q1206
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);


        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();  // 빌딩 수
            int[] heights = new int[N];  // 각 빌딩의 높이를 저장하는 배열

            for (int i = 0; i < N; i++) {
                heights[i] = sc.nextInt();
            }

            int count = 0;

            // 양쪽 두 빌딩이 비어있는 조망권 확인
            for (int i = 2; i < N - 2; i++) {
                int currentHeight = heights[i];

                // 양옆 두 빌딩 중 가장 높은 높이 찾기
                int maxNeighborHeight = Math.max(
                        Math.max(heights[i - 2], heights[i - 1]),
                        Math.max(heights[i + 1], heights[i + 2])
                );

                // 현재 빌딩이 양옆 빌딩들보다 높은 경우에만 조망권이 있음
                if (currentHeight > maxNeighborHeight) {
                    count += currentHeight - maxNeighborHeight;
                }
            }

            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}