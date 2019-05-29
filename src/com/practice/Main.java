package com.practice;

public class Main {

    public static void main(String[] args) {
        String s = "0p";
        s = s.toLowerCase();

        boolean isP = true;
        for(int i=0,j=s.length()-1;i<s.length();){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                ++i;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                --j;
                continue;
            }

            if( (s.charAt(i) != s.charAt(j))){
                isP = false;
                break;
            }
            ++i;
            --j;

        }

        System.out.println("isPalindrom::"+isP);


	// write your code here
    }
}
