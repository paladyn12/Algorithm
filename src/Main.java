import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제 번호:
 * 문제 이름:
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        Object[] array = set.toArray();
        Arrays.sort(array);
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            map.put((Integer) array[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(map.get(num)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}