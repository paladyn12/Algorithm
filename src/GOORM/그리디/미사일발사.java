package GOORM.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 같은 시각에 동시에 날아가는 미사일의 최대 개수를 구하는 문제
 * Missle의 출발, 도착 시각과 도착 여부를 저장하고 정렬하기 위한 클래스 및 배열 선언
 * 현재 발사되어 날아가는 중인 Missile 개수를 current 변수에서 저장
 * 배열을 시간 순으로 탐색하며 출발한 Missile인 경우 current++, 도착한 Missile인 경우 current--
 * 전체 S - maxCurrent 계산
 */

class 미사일발사 {

    static long S = 0;

    static class Missile implements Comparable<Missile> {
        long time;
        boolean arrive;

        public Missile(long time, boolean arrive) {
            this.time = time;
            this.arrive = arrive;
        }

        @Override
        public int compareTo(Missile o) {
            if (this.time != o.time) {
                return Long.compare(this.time, o.time); // time 오름차순
            }
            return Boolean.compare(o.arrive, this.arrive); // launch가 true인 걸 앞으로
        }
    }

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Missile[] missile = new Missile[N * 2];
        for (int i = 0; i < missile.length; i+=2) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            long T = Long.parseLong(st.nextToken());
            long d = (long) ((Math.pow(X, 2) + Math.pow(Y, 2)) * 2);
            S += d;
            missile[i] = new Missile(T, false);
            missile[i + 1] = new Missile(d + T, true);
        }
        Arrays.sort(missile);

        int maxCurrent = 0;
        int current = 0;
        for (int i = 0; i < missile.length; i++) {
            if (!missile[i].arrive) {
                current++;
            } else {
                current--;
            }
            maxCurrent = Math.max(maxCurrent, current);
        }

        System.out.println(S - maxCurrent);
    }
}