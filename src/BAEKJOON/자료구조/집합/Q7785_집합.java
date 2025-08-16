import java.util.*;
import java.io.*;

class Q7785_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[1].equals("enter")) set.add(input[0]);
            else if (input[1].equals("leave")) set.remove(input[0]);
        }

        StringBuilder sb = new StringBuilder();
        while (!set.isEmpty()) {
            sb.append(set.last()).append("\n");
            set.remove(set.last());
        }
        System.out.print(sb);
    }
}
