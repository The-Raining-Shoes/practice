package com.example.item.zrExam.nineSplitTest;


import com.example.item.utils.CheckUtil;

/**
 * 中级分割
 *
 * @author HXM
 * @date 2020年04月10日 11:09
 */
public class MidSplitTest {
    public static void main(String[] args) {
        String s = "  $a.x > $X12 22 && $b || $F12[1] 555==中国 $Names[2] ";
        char[] ca = s.toCharArray();
        StringBuilder a = new StringBuilder();
        boolean trues = false;
        // 方法1 直接循环输出
        for (char adsad : ca) {
            if (adsad == '$') {
                trues = true;
                continue;
            } else if (adsad == ' ' || adsad == '.' || adsad == ',' || adsad == '[' || adsad == ']') {
                trues = false;
            }
            if (trues) {
                if (CheckUtil.isNotBlank(adsad)) {
                    a.append(adsad);
                }
            } else {
                if (!a.toString().equals("")) {
                    System.out.println(a.toString());
                    a.delete(0, a.length());
                }
            }
        }
        // 方法2 使用分割
//        List<String> list = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(a.toString(), "$");
//        while (st.hasMoreTokens()) {
//            list.add(st.nextToken());
//        }
//        for (String str : list) {
//            System.out.println(str);
//        }
    }
}
