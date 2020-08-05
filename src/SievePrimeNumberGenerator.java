import java.util.ArrayList;
import java.util.List;

/*
https://medium.com/@agilanbtdw/prime-number-generation-in-java-using-segmented-sieve-of-eratosthenes-187af1dcd051
 */
public class SievePrimeNumberGenerator {
    //This method is good when prime numbers to generate areless than 1 million
    //First run all multiple of 2 i.e.e 2,4,6,8,10
    //Second run all multiples of 3 i.e 3,6,69,12,15
    public void sieveOfEratosthenes(int n){
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<prime.length;i ++){
            prime[i] = true;
        }
        for(int i=2;i*i<=n;i ++) {
            if (prime[i]) {
                for (int j = i*i;j<=n ;j=j+i ) {
                    prime[j] = false;
                }
            }
        }

        for(int i = 2; i <= n; i++)
        {
            if(prime[i])
                System.out.print(i + " ");
        }
    }

    public void sieveSegmentBetween(int m,int n){
        int sqrtN = (int)Math.sqrt(n);
        boolean[] prime = new boolean[sqrtN+1];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<prime.length;i ++){
            prime[i] = true;
        }

        for(int i=2;i<=sqrtN;i++){
            for(int j= i*i;j<=sqrtN;j=j+i){
                if(prime[j])
                    prime[j] = false;
            }
        }

        for(int i=2;i<prime.length;i ++){
            if(prime[i] ){
                list.add(i);
            }
        }

        boolean[] primeArray = new boolean[n-m+1];
        for(int i=0;i<primeArray.length;i ++){
            primeArray[i] = true;
        }
        for(int i=0;i<list.size();i++){
            int elem = list.get(i);
            int div = m/elem;
            for(int j=div*elem;j<=n;j=j+elem){
                int idx = j-m;
                if(idx>=0 && primeArray[idx] && elem != j){
                    primeArray[idx] = false;
                }
            }
        }
        System.out.println("Prime numbers b/w "+m+","+n + " are as follows:: ");
        for(int i=0;i<primeArray.length;i ++){
            if(primeArray[i])
                System.out.print(m+i+" , ");
        }


    }

    public static void main(String[] args) {

        SievePrimeNumberGenerator g = new SievePrimeNumberGenerator();
        /*
        int n = 30;
        System.out.print("Following are the prime numbers ");
        System.out.println("smaller than or equal to " + n);
        g.sieveOfEratosthenes(n);
        System.out.println("\n==============10 ==========");
        g.sieveOfEratosthenes(10);
        System.out.println("\n============  20 ============");

        g.sieveOfEratosthenes(20);*/
        g.sieveSegmentBetween(95,115);
        System.out.println();
        g.sieveSegmentBetween(2,17);
    }
}
