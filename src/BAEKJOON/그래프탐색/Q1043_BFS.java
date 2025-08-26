import java.util.*;
import java.io.*;

class Q1043_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] people = new ArrayList[N + 1];
        ArrayList<Integer>[] parties = new ArrayList[M];
        
        for (int i = 0; i <= N; i++) people[i] = new ArrayList<>();

        ArrayDeque<Integer> know = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        for (int i = 0; i < number; i++) {
            know.addLast(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            number = Integer.parseInt(st.nextToken());
            for (int j = 0; j < number; j++) {
                int person = Integer.parseInt(st.nextToken());
                list.add(person);
                people[person].add(i);
            }
            parties[i] = list;
        }

        int ans = M;
        boolean[] visit = new boolean[M];
        while (!know.isEmpty()) {
            int knowingPerson = know.pollFirst();
            for (int party : people[knowingPerson]) {
                if (!visit[party]) {
                    visit[party] = true;
                    ans--;
                    for (int person : parties[party]) {
                        know.addLast(person);
                    }
                }
            }
        }
        
        System.out.print(ans);
    }
}
