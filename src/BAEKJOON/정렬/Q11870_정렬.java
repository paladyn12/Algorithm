package BAEKJOON.정렬;

import java.io.*;
import java.util.*;

/**
 * 문제 번호: 11870
 * 문제 이름: 좌표 압축
 * 문제 링크: https://www.acmicpc.net/problem/11870
 * 풀이: 주어진 숫자들을 HashSet에 넣어 중복 제거
 * 중복을 제거한 HashSet 내의 숫자들이 각각 몇 번째로 큰 숫자인지 index로 확인하기 위해 HashSet을 Sort
 * 처음 주어진 값이 각각 몇 번째로 큰 숫자인지 확인
 */

class Q11870_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        Object[] array = set.toArray();
        Arrays.sort(array);
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            map.put((Integer) array[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(map.get(num)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}
