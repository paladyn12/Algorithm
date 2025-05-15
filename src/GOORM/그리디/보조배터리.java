package GOORM.그리디;

import java.io.*;
import java.util.*;

/**
 * 가장 많은 충전기로 충전하는 경우의 수를 구하는 문제
 * 최대 경우의 수 : 각 타입으로만 충전 가능한 보조 배터리를 최대한 고른 후 모든 타입이 사용 가능한 보조 배터리는 남는 충전기로 충전
 * 먼저 X 타입 충전기, Y 타입 충전기를 가격을 기준으로 오름차순 정렬
 * 각 타입으로만 충전 가능한 보조 배터리를 충전하기 위해 가격이 저렴한 순으로 고름
 * 남은 충전기를 합쳐 다시 가격순 정렬
 * 모든 타입이 사용 가능한 보조 배터리를 남은 충전기에서 가격이 저렴한 순으로 고름
 */

class 보조배터리 {

    // 가격 총 합
    static long sum = 0;
    // 보조 배터리 개수
    static int count = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        // X, Y 타입 각각 ArrayList<Integer>에 저장 후 가격 순으로 정렬
        ArrayList<Integer> chargerX = new ArrayList<>();
        ArrayList<Integer> chargerY = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (t == 0) chargerX.add(c);
            else chargerY.add(c);
        }
        Collections.sort(chargerX);
        Collections.sort(chargerY);

        // X 타입으로만 충전 가능한 보조 배터리를 최대한 충전
        while (A > 0 && !chargerX.isEmpty()) {
            sum += chargerX.remove(0);
            count++;
            A--;
        }

        // Y 타입으로만 충전 가능한 보조 배터리를 최대한 충전
        while (B > 0 && !chargerY.isEmpty()) {
            sum += chargerY.remove(0);
            count++;
            B--;
        }

        // 각 보조 배터리를 충전한 뒤 남은 충전기를 합쳐 모든 타입으로 충전 가능한 보조 배터리 충전
        chargerX.addAll(chargerY);
        Collections.sort(chargerX);
        while (C > 0 && !chargerX.isEmpty()) {
            sum += chargerX.remove(0);
            count++;
            C--;
        }

        // 결과 출력
        System.out.println(count + " " + sum);
    }
}