package GOORM.자료구조;

import java.io.*;
import java.util.*;

class 아이템교환 {

    /**
     * 두 item set을 입력받아 서로 item을 가지고 있을 때 교환하는 로직을 작성하는 문제
     * contains 메서드를 사용해 item 소지 여부 확인
     * 정답 출력을 사전순으로 해야 하므로 TreeSet 사용
     */

    static TreeSet<String> goorm;
    static TreeSet<String> friend;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // TreeSet 선언 후 item 저장
        goorm = new TreeSet<>();
        friend = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            goorm.add(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            friend.add(st.nextToken());
        }

        // M 번 반복하며 item A, B 를 각각 가지고 있을 때 exchange()
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String itemA = input[0];
            String itemB = input[1];
            if (goorm.contains(itemA) && friend.contains(itemB)) exchange(itemA, itemB);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String item : goorm) {
            sb.append(item).append(" ");
        }
        System.out.print(sb);
    }

    // 각 Set에서 item을 빼고 반대편 item을 넣음
    static void exchange(String A, String B) {
        goorm.remove(A);
        goorm.add(B);
        friend.remove(B);
        friend.add(A);
    }
}