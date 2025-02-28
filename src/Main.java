import java.io.*;
import java.util.*;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            set.add(array[i]);
        }
        Object[] setArray = set.toArray();
        Arrays.sort(setArray);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < setArray.length; i++) {
            map.put((Integer) setArray[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(map.get(i)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}