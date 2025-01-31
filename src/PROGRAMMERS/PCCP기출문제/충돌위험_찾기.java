package PROGRAMMERS.PCCP기출문제;

public class 충돌위험_찾기 {
    public int solution(int[][] points, int[][] routes) {
        Robot[] robots = new Robot[routes.length];
        for (int i = 0; i < routes.length; i++) {
            robots[i] = new Robot(points[routes[i][0]], points[routes[i][1]]);
        }
        int count = 0;
        while(true) {
            int[][] board = new int[101][101];
            for (Robot robot : robots) {
                robot.move();
                if (board[robot.current[0]][robot.current[1]] == 1) count++;
                else board[robot.current[0]][robot.current[1]] = 1;
            }

            boolean flag = true;
            for (Robot robot : robots) {
                if (!robot.done) flag = false;
            }
            if (flag) break;
        }
        int answer = count;
        return answer;
    }

}
class Robot {
    int[] current = new int[2];
    int[] goal = new int[2];
    boolean done;
    public void move() {
        if (!done) {
            if (current[0] > goal[0]) current[0]--;
            else if (current[0] < goal[0]) current[0]++;
            else if (current[1] > goal[1]) current[1]--;
            else current[1]++;

            if (current[0] == goal[0] && current[1] == goal[1]) done = true;
        }
    }
    public Robot(int[] current, int[] goal) {
        this.current[0] = current[0];
        this.current[1] = current[1];
        this.goal[0] = goal[0];
        this.goal[1] = goal[1];
        done = false;
    }
}