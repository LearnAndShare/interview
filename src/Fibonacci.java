import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public void fib(int n){
        int a = 0;
        int b = 1;
        System.out.print("First " + n + " terms: ");
        int finalSum = 0;
        for(int i=1;i<=n;i++){
            System.out.print(a + " , ");
            int sum = a+b;
            finalSum +=a;
            a = b;
            b = sum;
        }
        System.out.println("\n Final Sum::"+finalSum);
    }

    public void fibDP(int n){
        int a = 0;
        int b = 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.print("First " + n + " terms: ");
        int finalSum = 0;
        for(int i=2;i<=n;i++){
           dp[i] = dp[i-1]+dp[i-2];
            System.out.print(dp[i]+",");
        }
        System.out.println("\n Final Num::"+dp[n]);
    }

    Map<Integer,Integer> fibMemo = new HashMap<>();
    public int fibRecurse(int n){
        if(n <=1)
            return n;
        return fibRecurse(n-1)+fibRecurse(n-2);
    }

    public int fibRecurseMemo(int n){
        if(n <=1)
            return n;
        if(fibMemo.containsKey(n))
            return fibMemo.get(n);
        fibMemo.put(n, fibRecurseMemo(n-1)+fibRecurseMemo(n-2));
        return fibMemo.get(n);

    }

    public static void main(String[] args) {
        Fibonacci fibn = new Fibonacci();
        fibn.fib(5);
        System.out.println("Fib DP!!!");
        fibn.fibDP(9);

        System.out.println("Recurse::"+fibn.fibRecurse(9));
        System.out.println("Recurse::"+fibn.fibRecurseMemo(9));
    }
}
