import java.util.*;
import java.io.*;
import java.text.*;

class Q10699_기본문제 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println(df.format(date));
    }
}
