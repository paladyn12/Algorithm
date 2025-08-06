import java.util.*;
import java.io.*;

class Solution {

    static int[][] array;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();

            array = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 99;

            for (int i = 0; i < 100; i++) {
                int curX = 0;
                int curY = i;
                if (array[curX][curY] == 0) continue;
                while (curX < 99) {
                    if (curY > 0 && array[curX + 1][curY - 1] == 1) {
                        curX++;
                        // 다음 y 값이 없거나 0일 때 까지 --
                        int ny = curY - 1;
                        while (ny >= 0) {
                        	if (array[curX][ny] == 0) break;
                        	curY = ny;
                        	ny = curY - 1;
                        }
                    } else if (curY < 99 && array[curX + 1][curY + 1] == 1) {
                        curX++;
                        int ny = curY + 1;
                        while (ny <= 99) {
                            // 다음 y 값이 없거나 99일 때 까지 ++
                        	if (array[curX][ny] == 0) break;
                        	curY = ny;
                        	ny = curY + 1;
                        }
                    } else curX++;
                }
                if (array[curX][curY] == 2) {
                    result = i;
                    break;
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
