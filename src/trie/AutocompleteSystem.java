package trie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
https://leetcode.com/problems/design-search-autocomplete-system/
Performance Analysis
AutocompleteSystem() takes O(k∗l) time. We need to iterate over l sentences each of average length k, to create the trie for the given set of sentences.
input() takes O(p+q+mlogm) time. Here, p refers to the length of the sentence formed till now,cur_sent
q refers to the number of nodes in the trie considering the sentence formed till now as the root node.
Again, we need to sort the list of length m indicating the options available for the hot sentences, which takes O(mlogm) time.
*/
/*
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:
The constructor function:
AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.
Now, the user wants to input a new sentence. The following function will provide the next character the user types:
List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.

Note:
The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */

class AutocompleteSystem {
    class TrieNode implements Comparable<TrieNode> {
        int sentHitFreq; // If this is end of sentence, hit freq > 0. Else, 0.
        List<TrieNode> hotList; // Holds top 3 sentences that travel via this node.
         String sentence; // Last node of sentence also stores the sentence.
        TrieNode[] children;
        TrieNode(){
            sentence = null;
            sentHitFreq = 0;
            children = new TrieNode[27]; // Idx 26 is used for ' '.
            hotList = new ArrayList<>(3);
        }
        public int compareTo(TrieNode that){
            if(this.sentHitFreq == that.sentHitFreq){
                return this.sentence.compareTo(that.sentence);
            }

            return that.sentHitFreq - this.sentHitFreq; // Desc order.
        }

        void updateHotList(TrieNode sentEndNode){
            if(!hotList.contains(sentEndNode)){ // Adding a sentence node that already exists would be erroneous.
                hotList.add(sentEndNode);
            }
            Collections.sort(hotList); // Implemented compareTo will be used.

            if(hotList.size() > 3){
                hotList.remove(hotList.size() - 1);
            }
        }
    }
    private TrieNode[] children;







    private TrieNode root;
    private TrieNode iterNodeThatRemembers; // Picks up where left off & doesn't always start from root unless reset.
    private StringBuilder inpStr;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        iterNodeThatRemembers = root;
        inpStr = new StringBuilder();

        for(int idx = 0; idx < sentences.length; ++idx){
            addSentence(sentences[idx], times[idx]);
        }
    }

    private void addSentence(String sent, int times){
        TrieNode iterNode = root;
        List<TrieNode> visitedNodes = new ArrayList<>();

        for(int idx = 0; idx < sent.length(); ++idx){
            int idxInChildArr = getArrIdxForChar(sent.charAt(idx));

            if(iterNode.children[idxInChildArr] == null){
                iterNode.children[idxInChildArr] = new TrieNode();
            }

            iterNode = iterNode.children[idxInChildArr];
            visitedNodes.add(iterNode);
        }

        // Reached the end of setence. The last node holds the hit freq and the sentence itelf.
        iterNode.sentHitFreq += times;
        iterNode.sentence = sent;

        for(TrieNode nodeInPath: visitedNodes){
            nodeInPath.updateHotList(iterNode); // As new sentence went via this node, hotList needs updating.
        }
    }

    public List<String> input(char c) {
        List<String> retHotList = new ArrayList<>();

        if(c == '#'){
            addSentence(inpStr.toString(), 1); // 1 might get summed with hitFreq if sentence already in history.
            iterNodeThatRemembers = root; // Reset.
            inpStr = new StringBuilder(); // Reset.
            return retHotList;
        }

        inpStr.append(c);

        int idxInChildArr = getArrIdxForChar(c);
        if(iterNodeThatRemembers != null){
            iterNodeThatRemembers = iterNodeThatRemembers.children[idxInChildArr];
        }

        if(iterNodeThatRemembers == null){
            return retHotList; // If input char doesn't exist in any prefix path, return empty list.
        }

        for(TrieNode sentEndNode: iterNodeThatRemembers.hotList){
            retHotList.add(sentEndNode.sentence); // Input char exists in prefix path. Populate retList with hotList.
        }

        return retHotList;
    }

    private int getArrIdxForChar(char c){
        return c == ' ' ? 26 : c - 'a';
    }

    public static void main(String[] args) {
        String[] se = {"i love you","island","iroman","i love leetcode"};
        int[] t = {5,3,2,2};
        AutocompleteSystem as = new AutocompleteSystem(se,t);
        as.input('i').forEach(System.out::println);
    }

}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */