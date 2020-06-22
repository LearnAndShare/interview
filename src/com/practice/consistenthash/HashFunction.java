package com.practice.consistenthash;

public class HashFunction {
    public int hash(String value){
        return value.hashCode()%67;
    }
}
