import java.io.*;
import java.util.*;

public class Q17387_선분교차판정 {
    
	static class Node {
		long x, y;

		public Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Node[] point = new Node[4];
		
		long x1, y1, x2, y2, x3, y3, x4, y4;

		st = new StringTokenizer(br.readLine());
		x1 = Long.parseLong(st.nextToken());
		y1 = Long.parseLong(st.nextToken());
		x2 = Long.parseLong(st.nextToken());
		y2 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x3 = Long.parseLong(st.nextToken());
		y3 = Long.parseLong(st.nextToken());
		x4 = Long.parseLong(st.nextToken());
		y4 = Long.parseLong(st.nextToken());

		point[0] = new Node(x1, y1);
		point[1] = new Node(x2, y2);
		point[2] = new Node(x3, y3);
		point[3] = new Node(x4, y4);

		System.out.print(checkCCW(point));
	}

    static int checkCCW(Node[] p) {
        boolean flag = false;
        
        boolean comp1 = Math.max(p[0].x, p[1].x) >= Math.min(p[2].x, p[3].x);
        boolean comp2 = Math.max(p[2].x, p[3].x) >= Math.min(p[0].x, p[1].x);
        boolean comp3 = Math.max(p[0].y, p[1].y) >= Math.min(p[2].y, p[3].y);
        boolean comp4 = Math.max(p[2].y, p[3].y) >= Math.min(p[0].y, p[1].y);

        int p012 = ccw(p[0], p[1], p[2]);
        int p013 = ccw(p[0], p[1], p[3]);
        int p230 = ccw(p[2], p[3], p[0]);
        int p231 = ccw(p[2], p[3], p[1]);

        if (p012 * p013 == 0 && p230 * p231 == 0) {
            flag = true;
            if (comp1 && comp2 && comp3 && comp4) return 1;
        }
        if (p012 * p013 <= 0 && p230 * p231 <= 0) {
			if (!flag)
				return 1;
		}
		return 0;
    }

    static int ccw(Node p1, Node p2, Node p3) {
        long res = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x);
        if (res > 0) return 1;
        else if (res < 0) return -1;
        else return 0;
    }
}
