package BAEKJOON.구현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 번호: 11005
 * 문제 이름: 진법 변환 2
 * 풀이: 10진수를 Base로 나누며 각 자릿수를 구하고 이를 문자화
 */
class Q11005_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(N%B);
        while(N >= B) {
            N /= B;
            nums.add(N%B);
        }
        Collections.reverse(nums);

        StringBuilder sb = new StringBuilder();

        for (Integer num : nums) {
            sb.append(toChar(num));
        }

        System.out.println(sb);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
    private static char toChar(int num) {
        if (num < 10) {
            return (char) (num + 48);
        } else return (char) (num + 55);
    }
}