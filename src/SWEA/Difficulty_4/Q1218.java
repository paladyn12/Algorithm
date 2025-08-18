import java.io.*;
import java.util.*;

public class Q1218 {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			boolean flag = true;
			
			ArrayDeque<Character> dq = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				char c = input.charAt(i);
				if (c == '(' || c == '[' || c == '{' || c == '<') dq.addLast(c);
				else if (c == ')' || c == ']' || c == '}' || c == '>') {
					if (dq.isEmpty()) {
						flag = false;
						break;
					} else {
						char top = dq.pollLast();
						switch (c) {
							case ')':
								if (top != '(') flag = false;
								break;
							case ']':
								if (top != '[') flag = false;
								break;
							case '}':
								if (top != '{') flag = false;
								break;
							case '>':
								if (top != '<') flag = false;
								break;
						}
					}
				}
			}
			if (!dq.isEmpty()) flag = false;
			
			int ans = flag ? 1 : 0;
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
