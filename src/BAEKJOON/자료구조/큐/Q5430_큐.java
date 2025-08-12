import java.util.*;
import java.io.*;

class Q5430_큐 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String P = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String inputNumbers = br.readLine();
            inputNumbers = inputNumbers.substring(1, inputNumbers.length() - 1);
            String[] inputArrays = inputNumbers.split(",");
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            
            for (int i = 0; i < N; i++) {
                dq.addLast(Integer.parseInt(inputArrays[i]));
            }

            boolean flag = true;
            boolean error = false;
            for (int i = 0; i < P.length(); i++) {
                char operation = P.charAt(i);
                switch (operation) {
                    case 'R':
                        flag = !flag;
                        break;
                    case 'D':
                        if (dq.isEmpty()) {
                            error = true;
                            break;
                        }
                        if (flag) dq.pollFirst();
                        else dq.pollLast();
                        break;
                }
            }
            if (error) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            if (!dq.isEmpty()) {
                while (dq.size() > 1) {
                    if (flag) sb.append(dq.pollFirst()).append(",");
                    else sb.append(dq.pollLast()).append(",");
                }
                sb.append(dq.pollLast());
            }
            
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}
