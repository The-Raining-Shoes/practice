package com.example.item.method.splitWord;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JieBaUtil {

    public static void main(String[] args) {

        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        String targetWord = "机器学习是一门多领域交叉学科，涉及概率论、统计学统计学统计学、逼近论、凸分析、算法复杂度理论等多门学科。";
        String analysisWord = "涉及概率论、统计学统计学我osws";
//        单词
        List<String> targetList = jiebaSegmenter.sentenceProcess(targetWord);
        System.out.println(targetList);
        Map<String, Integer> targetWordList = new HashMap<>();
        int i = 1;
        for (String str : targetList) {
            if (!targetWordList.containsKey(str)) {
                targetWordList.put(str, i);
                i++;
            }
        }
        List<String> analysisList = jiebaSegmenter.sentenceProcess(analysisWord);
        System.out.println(analysisList);
        List<Integer> resultList = new ArrayList<>();
        for (String str : analysisList) {
            boolean ifFind = false;
            for (String key : targetWordList.keySet()) {
                if (str.equals(key)) {
                    resultList.add(targetWordList.get(key));
                    ifFind = true;
                }
            }
            if (!ifFind) {
                resultList.add(0);
            }
        }
        System.out.println(resultList);

//        多词
//        String[] sentences =
//                new String[]{"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
//                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
//        for (String sentence : sentences) {
//            System.out.println(jiebaSegmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
//        }

    }

}
