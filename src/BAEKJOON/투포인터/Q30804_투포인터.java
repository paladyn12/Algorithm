import java.io.*;
import java.util.*;


public class Q30804_투포인터 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int type = 0;
        int[] visit = new int[10];
        int result = 0;
        
        while (end < N) {
            int currentFruit = fruits[end];

            // 현재 과일이 처음 방문하는 것일 때
            if (visit[currentFruit] == 0) {

                // 아무것도 넣지 않음
                if (type == 0) {
                    type++;
                    visit[currentFruit] = 1;
                
                }

                // 하나 들어있었음
                else if (type == 1) {
                    type++;
                    for (int i = 1; i <= 9; i++) {
                        if (visit[i] == 1) visit[i] = 2;
                    }
                    visit[currentFruit] = 1;
                }

                // 이미 두 종류가 들어있었음
                else {
                    start = end - 1;
                    for (int i = start; i >= 0; i--) {
                        int beforeFruit = fruits[i];
                        if (visit[beforeFruit] == 2) {
                            start = i + 1;
                            visit[beforeFruit] = 0;
                            break;
                        }
                    }
                    for (int i = 1; i <= 9; i++) {
                        if (visit[i] == 1) visit[i] = 2;
                    }
                    visit[currentFruit] = 1;
                }
            } else {
                if (visit[currentFruit] == 2) {
                    for (int i = 1; i <= 9; i++) {
                        if (visit[i] == 1) visit[i] = 2;    
                    }
                    visit[currentFruit] = 1;
                }
            }
            end++;
            result = Math.max(result, end - start);
        }
        result = Math.max(result, end - start);
        System.out.print(result);
        
    }
}
