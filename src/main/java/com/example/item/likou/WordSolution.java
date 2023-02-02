package com.example.item.likou;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>(WordSolution)</b>
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/7
 */
public class WordSolution {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("catt");
        list.add("cat");
        list.add("bat");
        list.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new WordSolution().replaceWords(list, sentence));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            for (String word : dictionary) {
                if (s[i].startsWith(word)) {
                    s[i] = word;
                }
            }
        }
        return String.join(" ", s);
//        Set<String> dictionarySet = new HashSet<>(dictionary);
//        String[] words = sentence.split(" ");
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            for (int j = 0; j < word.length(); j++) {
//                if (dictionarySet.contains(word.substring(0, 1 + j))) {
//                    words[i] = word.substring(0, 1 + j);
//                    break;
//                }
//            }
//        }
//        return String.join(" ", words);
    }

}
