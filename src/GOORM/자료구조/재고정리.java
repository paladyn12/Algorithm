package GOORM.자료구조;

import java.io.*;
import java.util.*;

class 재고정리 {
    /**
     * 음식 종류와 개수를 입력받아 최종적인 종류별 개수를 종류 기준 오름차순으로 출력하는 문제
     * TreeMap 을 사용해 key를 기준으로 자동 정렬하는 자료구조 사용
     * items.put(type, items.getOrDefault(type, 0) + count); 구문에서 이미 값이 있으면 추가, 아니면 count를 넣도록 구현
     */
    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // TreeMap
        TreeMap<String, Integer> items = new TreeMap<>();

        // 이미 key가 있다면 추가, 아니면 입력값으로 생성
        // getOrDefault(key, n) : key 값이 있으면 value, 없으면 n 값을 반환
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            String type = split[0];
            int count = Integer.parseInt(split[1]);
            items.put(type, items.getOrDefault(type, 0) + count);
        }

        // 여러 줄을 출력하므로 StringBuilder
        StringBuilder sb = new StringBuilder();
        for (String type : items.keySet()) {
            sb.append(type).append(" ").append(items.get(type)).append("\n");
        }
        System.out.println(sb);
    }
}