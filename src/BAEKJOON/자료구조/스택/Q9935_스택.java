import java.util.*;
import java.io.*;

class Q9935_스택 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String keyword = br.readLine();
        int keyLength = keyword.length();
        StringBuilder ans = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= keyLength) {
                boolean flag = true;

                for (int j = 0; j < keyLength; j++) {
                    if (stack.get(stack.size() - keyLength + j) != keyword.charAt(j)) flag = false;
                }

                if (flag) {
                    for (int j = 0; j < keyLength; j++) {
                        stack.pop();
                    }
                }
            }
        }
        for (Character c : stack) ans.append(c);
        
        System.out.print(ans.toString().equals("") ? "FRULA" : ans.toString());
    }
}
