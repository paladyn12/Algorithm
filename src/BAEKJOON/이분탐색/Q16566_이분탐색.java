import java.util.*;
import java.io.*;

class Q16566_이분탐색 {
    static ArrayList<Integer> minsu = new ArrayList<>();
    static boolean[] used;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            minsu.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(minsu);
        used = new boolean[M];
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(logic(num)).append("\n");
        }
        System.out.print(sb);
    }
    
    static int logic(int num) {
        int left = 0;
        int right = minsu.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (minsu.get(mid) > num) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // result부터 사용하지 않은 카드 찾기
        while (result < minsu.size() && used[result]) {
            result++;
        }
        
        used[result] = true;
        return minsu.get(result);
    }
}
