import java.util.*;
import java.io.*;

class Q28702_문자열 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        if (str1.equals("Fizz")) {
            if (!str2.equals("Buzz") && !str3.equals("Buzz")) {
                if ((Integer.parseInt(str2) + 2) % 15  == 0) System.out.print("FizzBuzz");
                else System.out.print("Fizz");
            }
            else System.out.print("Fizz");
        } else if (str1.equals("Buzz")) {
            if (str2.equals("Fizz")) System.out.print(Integer.parseInt(str3) + 1);
            else System.out.print(Integer.parseInt(str2) + 2);
        } else if (str1.equals("FizzBuzz")) System.out.print("Fizz");
        else {
            int n = Integer.parseInt(str1) + 3;
            if (n % 3 == 0 && n % 5 == 0) System.out.print("FizzBuzz");
            else if (n % 3 == 0) System.out.print("Fizz");
            else if (n % 5 == 0) System.out.print("Buzz");
            else System.out.print(n);
        }
    }
}
