import java.io.*;
import java.util.*;

class Q5658 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int base = N / 4;

            char[] numbers = new char[N];
            String input = br.readLine();
            for (int i = 0; i < N; i++) {
                numbers[i] = input.charAt(i);
            }

            TreeSet<String> set = new TreeSet<>((o1, o2) -> {
                return o2.compareTo(o1);
            });

            for (int rotate = 0; rotate < base; rotate++) {
                for (int i = 0; i < N; i+=base) {
                    StringBuilder builder = new StringBuilder();
                    for (int j = 0; j < base; j++) {
                        builder.append(numbers[i + j]);
                    }
                    set.add(builder.toString());
                }
                char temp = numbers[N - 1];
                for (int i = N - 1; i > 0; i--) {
                    numbers[i] = numbers[i - 1];
                }
                numbers[0] = temp;
            }
            
            for (int i = 0; i < K - 1; i++) {
                set.pollFirst();
            }

            sb.append("#").append(test_case).append(" ").append(logic(set.pollFirst())).append("\n");
        }
        System.out.print(sb);
    }

    static int logic(String str) {
        int sum = 0;
        int idx = str.length() - 1;
        int base = 1;
        while (idx >= 0) {
            char c = str.charAt(idx);
            if (c >= 'A') {
                sum += (c - 'A' + 10) * base;
            } else {
                sum += (c - '0') * base;
            }
            idx--;
            base *= 16;
        }
        return sum;
    }
}
