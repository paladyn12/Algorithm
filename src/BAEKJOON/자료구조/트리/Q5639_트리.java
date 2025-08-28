import java.util.*;
import java.io.*;

class Q5639_트리 {

    static class Node {
        int number;
        Node left;
        Node right;

        public Node (int number) {
            this.number = number;
            left = null;
            right = null;
        }
    }

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rootNum = Integer.parseInt(br.readLine());
        Node root = new Node(rootNum);
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);

        String line;
        while ((line = br.readLine()) != null) {
            int nextNum = Integer.parseInt(line);
            Node next = new Node(nextNum);
            
            if (nextNum < stack.peekLast().number) {
                stack.peekLast().left = next;
                stack.addLast(next);
            } else {
                Node lastPop = null;
                while (!stack.isEmpty() && nextNum > stack.peekLast().number) {
                    lastPop = stack.pollLast();
                }
                lastPop.right = next;
                stack.addLast(next);
            }
        }

        search(root);
        System.out.print(sb);
    }

    static void search(Node root) {
        if (root.left != null) search(root.left);
        if (root.right != null) search(root.right);
        sb.append(root.number).append("\n");
    }
}
