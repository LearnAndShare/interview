package ik.sort;

public class DutchFlag{
    public static void dutch_flag_sort(char[] balls) {
        int start =0;
        int end = balls.length-1;
        int curr = 0;
        while(curr<=end){
            if(balls[curr] == 'B'){
                swapBalls(balls,curr,end);
                end--;
            } else if(balls[curr] == 'R'){
                swapBalls(balls,curr,start);
                start++;
                curr++;
            } else{
                curr++;
            }
        }
    }

    public static void swapBalls(char[] balls,int idx1,int idx2){
        char tmp = balls[idx1];
        balls[idx1] = balls[idx2];
        balls[idx2] = tmp;
    }

    public static void main(String[] args) {
        char[] c = new char[]{ 'R'};
        dutch_flag_sort(c);
        for (char c1 : c) {
            System.out.print(c1+" , ");
        }
    }
}
