package com.yao;

import javax.security.auth.Subject;
import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author yanghui
 * @create 2019-08-30 10:07
 * @description
 */
public class Test {
    public static void main(String[] args){
        String str = "abcde3fghabcd";
        String str2 = new String("abcde3fghabcd");
        StringBuffer sb = new StringBuffer();
        sb.append("aaac");
        System.out.println(str.compareToIgnoreCase("AAAC"));
        System.out.println(str.concat("cc"));
        System.out.println(str.contains("a"));
        System.out.println(str.contentEquals("aaa"));
        System.out.println(str.contentEquals(sb));
        char[] ch = {'a','b','c','d','e'};
        System.out.println(String.copyValueOf(ch));
        System.out.println(String.copyValueOf(ch,1,3));
        System.out.println(str.endsWith("ac"));
        System.out.println(str.startsWith("aa"));
        System.out.println(str.indexOf('3'));
        System.out.println(str.indexOf("fg"));
        System.out.println(str.indexOf("abcd",1));
        System.out.println(str2 == str);
        System.out.println(str2.intern() == str);
        System.out.println(str.isEmpty());
        System.out.println(String.join(" ", "a","b","c"));
        System.out.println(str.lastIndexOf("fg"));
        System.out.println(str.lastIndexOf("fg",6));
        System.out.println(str.lastIndexOf('h'));
        System.out.println("12".matches("\\d+"));
        System.out.println(str.offsetByCodePoints(7, 1));
        System.out.println(str.regionMatches(true, 1, "cde", 3, 3));
        System.out.println(str.replace("3", "efg"));


    }
}
