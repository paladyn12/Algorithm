import java.util.*;
import java.io.*;

class Q1269_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setA_temp = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int n = Integer.parseInt(st.nextToken());
            setA.add(n);
            setA_temp.add(n);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int n = Integer.parseInt(st.nextToken());
            setB.add(n);
            setA.remove(n);
        }

        for (int n : setA_temp) {
            setB.remove(n);
        }

        System.out.print(setA.size() + setB.size());
    }
}
