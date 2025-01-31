package PROGRAMMERS.PCCP기출문제;

public class 동영상_재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int[] videoNum = toNum(video_len);
        int[] posNum = toNum(pos);
        auto(posNum, toNum(op_start), toNum(op_end));
        for (String command : commands) {
            switch (command) {
                case "prev":
                    if (toSec(posNum) < 10) posNum[1] = 0;
                    else {
                        int temp = toSec(posNum) - 10;
                        posNum[0] = temp/60;
                        posNum[1] = temp%60;
                    }
                    break;
                case "next":
                    if (toSec(videoNum) - toSec(posNum) < 10) {
                        posNum[1] = videoNum[1];
                        posNum[0] = videoNum[0];
                    } else {
                        int temp = toSec(posNum) + 10;
                        posNum[0] = temp/60;
                        posNum[1] = temp%60;
                    }
                    break;
            }
            auto(posNum, toNum(op_start), toNum(op_end));
        }

        answer = toString(posNum);
        return answer;
    }
    public int[] toNum(String pos) {
        String[] split = pos.split(":");
        int m = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);
        return new int[]{m, s};
    }
    public void auto(int[] nums, int[] op_start, int[] op_end) {
        if (toSec(nums) >= toSec(op_start) && toSec(nums) <= toSec(op_end)) {
            nums[1] = op_end[1];
            nums[0] = op_end[0];
        }
    }
    public int toSec(int[] nums) {
        return nums[0]*60 + nums[1];
    }
    public String toString(int[] nums) {
        String str = "";
        if (nums[0] < 10) str = str + "0" + String.valueOf(nums[0]);
        else str += nums[0];
        str += ":";
        if (nums[1] < 10) str = str + "0" + String.valueOf(nums[1]);
        else str += nums[1];
        return str;
    }
}
