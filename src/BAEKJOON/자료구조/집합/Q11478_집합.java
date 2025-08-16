import java.util.*;
import java.io.*;

class Q11478_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                set.add(str.substring(i, j));
            }
        }
        System.out.print(set.size());
    }
}
