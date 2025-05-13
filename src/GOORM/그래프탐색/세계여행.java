package GOORM.그래프탐색;

import java.io.*;
import java.util.*;

/**
 * 배우는 언어에 따라 방문할 수 있는 나라 수를 구하는 문제
 * 각 언어를 배울 때마다 방문 가능한 나라를 DFS 방식으로 탐색
 * Nation class를 정의해 각 나라별 언어와 이동 가능한 나라를 저장
 */
class 세계여행 {

    static class Nation {
        int language;
        LinkedList<Integer> linked = new LinkedList<>();

        public Nation(int language) {
            this.language = language;
        }

        void add(int e) {
            linked.add(e);
        }
    }

    // 방문한 나라는 true, 방문하지 않은 나라는 false
    static boolean[] visited;
    static Nation[] nations;
    static int N;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nations = new Nation[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nations[i] = new Nation(Integer.parseInt(st.nextToken()));
        }

        // M번 반복하며 양방향으로 탐색 가능한 나라를 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nations[s].add(e);
            nations[e].add(s);
        }

        // 1 ~ 10번 언어마다 dfs 탐색을 수행하여 수행 결과를 반환하는 logic() 메서드 실행
        int result = 0;
        for (int i = 1; i <= 10; i++) {

            // 1번째 나라 언어는 이미 배웠으므로 탐색할 필요 없음
            if (i == nations[1].language) continue;
            result = Math.max(result, logic(i));
        }

        // 결과 출력
        System.out.print(result);
    }

    // visited 초기화
    // dfs(edge, language) : 방문하지 않았고 사용 가능한 언어를 쓴다면 탐색
    // 최종적으로 dfs 탐색이 끝난 뒤 방문한 나라 수를 반환
    static int logic(int language) {
        visited = new boolean[N + 1];
        dfs(1, language);

        int count = 0;
        for (boolean visit : visited) {
            if (visit) count++;
        }
        return count;
    }

    static void dfs(int edge, int language) {
        visited[edge] = true;
        for (int linkedNation : nations[edge].linked) {
            if (!visited[linkedNation] && (nations[linkedNation].language == language || nations[linkedNation].language == nations[1].language)) {
                dfs(linkedNation, language);
            }
        }
    }
}