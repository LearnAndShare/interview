package com.practice.vocabulary;

public interface Vocabulary {
    boolean add(String word);
    boolean isPrefix(String prefix);
    boolean contains(String word);
    String getName();
}
