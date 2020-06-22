package com.practice;
/*
https://leetcode.com/problems/count-primes/
 */
public class PrimeNumber {
    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] prime = new boolean[n];
        for (int i = 0; i < prime.length; i++) {
           prime[i] = true;
        }

        for(int i=2;i*i<n;i++){
            if(prime[i]){
                for(int p=i*i;p<n;p=p+i){
                    prime[p] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < prime.length; i++) {
            if(prime[i])
                cnt++;
        }
        return cnt;
    }
    public int countPrimesIter(int n) {
        if(n <=2)
            return 0;
        if(n <= 3)
            return 1;
        if(n <= 5)
            return 2;
        if(n <= 7)
            return 3;
        int np = 4;
        boolean isPrime = true;
        for(int j=8;j<n;j++){
            for(int i=2;i<n;i++){
                if(j!=i && j%i ==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                np++;
        }
        return np;
    }

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        System.out.println(pn.countPrimes(12));
    }
}
