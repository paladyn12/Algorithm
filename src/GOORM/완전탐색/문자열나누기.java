package GOORM.완전탐색;

import java.io.*;
import java.util.*;

class 문자열나누기 {
    /**
     * 문자열을 나눌 수 있는 모든 경우의 수로 나눠봄
     * TreeSet에 각 문자열을 넣어 중복 제거 및 정렬
     * 모든 문자열 조합을 ArrayList<String[]> 에 저장
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        ArrayList<String[]> strCombine = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        // 모든 문자열 조합을 TreeSet에 넣으며 중복 제거, 정렬
        // 문자열을 만들 수 있는 조합을 배열로 만들어 ArrayList 에 저장
        for (int j = 1; j < N-1; j++) {
            for (int k = j + 1; k < N; k++) {
                String first = S.substring(0, j);
                String second = S.substring(j, k);
                String third = S.substring(k);
                strCombine.add(new String[]{first, second, third});
                set.add(first);
                set.add(second);
                set.add(third);
            }
        }

        // TreeSet -> String[]
        String[] strArray = set.toArray(new String[0]);

        // 최대값을 구할 result
        int result = Integer.MIN_VALUE;

        // 문자열을 만드는 모든 문자열 조합에 대한 반복
        for (String[] strings : strCombine) {
            int sum = 0;
            for (String string : strings) {
                sum += logic(string, strArray);
            }
            result = Math.max(sum, result);
        }

        System.out.println(result);
    }

    // 문자열이 배열의 몇 번째 인덱스인지 반환
    static int logic(String string, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(string)) return i+1;
        }
        return 0;
    }
}