package ik.sort;

import java.util.HashMap;
import java.util.Map;

public class LexicographicalOrder {
    static String[] solve(String[] arr) {
        /*
         * Write your code here.
         */
        Map<String, String> map = new HashMap<>();
        for (String s : arr) {
           String[] st =  s.split(" ");
           String mapStr= map.getOrDefault(st[0],""+"0,"+st[1]);
           String[] token = new String[2];
            int freq = 0;
           if(mapStr.length()>0){
               token = mapStr.split(",");
               freq = Integer.parseInt(token[0]);

           }
           ++freq;
           token[0] = String.valueOf(freq);
           if(st[1] != null && token[1] != null && st[1].compareTo(token[1])>0){
               token[1] = st[1];
           }
           StringBuilder temp = new StringBuilder();
           for (String s1 : token) {
             temp.append(s1).append(",");
            }
            temp.deleteCharAt(temp.length()-1);
             map.put(st[0],temp.toString());
        }

        String[] st = new String[map.keySet().size()];
        int idx = 0;
        for (String s : map.keySet()) {
            st[idx++] = s +":"+map.get(s);
        }
        return st;
    }

    public static void main(String[] args) {
        for (String s : solve(new String[]{"key1 abcd",

                "key2 zzz",

                "key1 hello",

                "key3 world",

                "key1 hello"})) {
            System.out.println(s);
        }
        System.out.println("================================================");
        for (String s : solve(new String[]{"mark zuckerberg",
                "tim cook",
                "mark twain"})) {
            System.out.println(s);
        }
    }


}
