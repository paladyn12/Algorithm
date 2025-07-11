package BAEKJOON.그래프탐색;

import java.util.*;
import java.io.*;

class Q1697_BFS
{

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] array = new int[100001];
        Arrays.fill(array, -1);

        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.addLast(K);
        array[K] = 0;
        while (!deq.isEmpty()) {
            int idx = deq.pollFirst();

            if (idx == N) {
                System.out.print(array[N]);
                break;
            }

            if (idx > 0) {
                if (array[idx-1] == -1) {
                    array[idx-1] = array[idx] + 1;
                    deq.addLast(idx-1);
                }
            }
            if (idx < 100000) {
                if (array[idx+1] == -1) {
                    array[idx+1] = array[idx] + 1;
                    deq.addLast(idx+1);
                }
            }
            if (idx % 2 == 0) {
                if (array[idx/2] == -1) {
                    array[idx/2] = array[idx] + 1;
                    deq.addLast(idx/2);
                }
            }
        }
    }
}