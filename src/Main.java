import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 20; i++) {
            int p = (int) (Math.random()*100);
            if (p <= 6) System.out.println("성공");
            else System.out.print("실패");
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}