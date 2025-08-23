import java.io.*;
import java.util.*;

public class Q13241_수학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long longA = Long.parseLong(st.nextToken());
        long longB = Long.parseLong(st.nextToken());
		
        long a = longA; // 30
        long b = longB; // 10
        long temp;

		while( b != 0 ){

			temp = a % b; 
			a = b; 
			b = temp; 

		}
		System.out.println(longA * longB / a);
	}
}
