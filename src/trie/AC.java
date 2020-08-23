package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AC {
    class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;
       public TrieNode() {
            children = new TrieNode[27];
            s = null;
            times = 0;
            hot = new ArrayList<>();
       }

        public int compareTo(TrieNode o) {
            if (this.times == o.times) {
                return this.s.compareTo(o.s);
            }

            return o.times - this.times;
        }

        public void update(TrieNode node) {
            if (!this.hot.contains(node)) {
                this.hot.add(node);
            }

            Collections.sort(hot);

            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
            /*if (!this.hotSentences.contains(node)) {
                this.hotSentences.add(node);
            }

            if (hotSentences.size() > 3) {
                hotSentences.poll();
            }*/

        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;
    public AC(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }


    public void add(String sentence, int t) {
        TrieNode tmp = root;

        List<TrieNode> visited = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            if (tmp.children[c] == null) {
                tmp.children[c] = new TrieNode();
            }

            tmp = tmp.children[c];
            visited.add(tmp);
        }

        tmp.s = sentence;
        tmp.times = t;

        for (TrieNode node : visited) {
            node.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
           // add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }

        sb.append(c);
        if (cur != null) {
            cur = cur.children[c];
        }

        if (cur == null) return res;
        for (TrieNode node : cur.hot) {
            res.add(node.s);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] se = {"i love you","island","iroman","i love leetcode"};
        int[] t = {5,3,2,2};
        AC as = new AC(se,t);
        as.input('i').forEach(System.out::println);
    }
}
